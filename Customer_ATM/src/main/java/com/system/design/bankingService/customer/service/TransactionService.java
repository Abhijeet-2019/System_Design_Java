package com.system.design.bankingService.customer.service;

import com.system.design.bankingService.customer.atmoperations.AtmOperations;
import com.system.design.bankingService.customer.atmoperations.WithDrawCash;
import com.system.design.bankingService.customer.domain.Customer;
import com.system.design.bankingService.customer.utils.ATMResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    @Qualifier("AuthenticateUser")
    AtmOperations authenticateUsers;

    @Autowired
    @Qualifier("CheckAccountBalance")
    private AtmOperations checkAccountBalance;

    @Autowired
    @Qualifier("WithDrawCash")
    private WithDrawCash withDrawCash;


    private ATMResponse atmResponse;

    public ATMResponse checkAccountBalance(String cardNo, String cardPin) {
        atmResponse = new ATMResponse();
        Customer authenticated_Customer = (Customer) authenticateUsers.performATMOperation(cardNo, cardPin, null);
        if (authenticated_Customer.isAuthenticated()) {
            // initiate to check Account balance..
            double balance = (double) checkAccountBalance.performATMOperation(cardNo, cardPin, authenticated_Customer);
            atmResponse.setResponseMsg("Transaction Successful");
            atmResponse.setData("Amount Balance  ==== " + balance);
            atmResponse.setTransactionStatus("Success");
        } else {
            authenticateUsers.exitAndReturnCard();
            authenticateUsers.cancelOperation();
            atmResponse.setResponseMsg("Unable to authenticate Customer");
            atmResponse.setTransactionStatus("Failed");
        }
        return atmResponse;
    }

    public ATMResponse withdrawCash(String cardNo, String cardPin, double withDrawAmount) {
        atmResponse = new ATMResponse();
        Customer authenticated_Customer = (Customer) authenticateUsers.performATMOperation(cardNo, cardPin, null);
        if (authenticated_Customer.isAuthenticated()) {
            // check if Sufficient cash available in account
            double accountBalance = (double) checkAccountBalance.performATMOperation(cardNo, cardPin, authenticated_Customer);
            if (accountBalance > withDrawAmount) {
                atmResponse.setResponseMsg("Transaction Successful");
                withDrawCash.performATMOperation(cardNo, cardPin, authenticated_Customer);
            } else {
                atmResponse.setTransactionStatus("Failed");
                atmResponse.setResponseMsg("Insufficient funds in account...Enter lesser amount");
            }
        } else {
            atmResponse.setTransactionStatus("Failed");
        }
        return atmResponse;
    }
}
