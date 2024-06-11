package com.system.design.bankingService.customer.atmoperations;

import com.system.design.bankingService.customer.domain.Customer;
import com.system.design.bankingService.customer.utils.BankAtmCommunication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("WithDrawCash")
public class WithDrawCash implements AtmOperations {


    @Autowired
    BankAtmCommunication bankAtmCommunication;


    /**
     *
     * Call The ATM Micro service to withdraw cash from ATM
     * Debit cash amount from Customer account.
     *
     * @param cardNO
     * @param cardPin
     * @param customer
     * @return
     */
    @Override
    public Object performATMOperation(String cardNO, String cardPin, Customer customer) {
        String customerId = String.valueOf(customer.getCustomer_ID());
        String accountNo = "12323";
        String withdrawAmount = String.valueOf(5000);
        return bankAtmCommunication.withdrawFromAccount(customerId,accountNo,withdrawAmount);
    }

    @Override
    public void cancelOperation() {

    }

    @Override
    public void exitAndReturnCard() {

    }
}
