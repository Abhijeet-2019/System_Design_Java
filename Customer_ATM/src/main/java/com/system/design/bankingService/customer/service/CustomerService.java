package com.system.design.bankingService.customer.service;


import com.system.design.bankingService.customer.domain.Card;

import com.system.design.bankingService.customer.domain.Customer;
import com.system.design.bankingService.customer.domain.Customer_Account;
import com.system.design.bankingService.customer.repositories.CustomerRepositories;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;


@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepositories customerRepositories;

    /**
     *
     * @param paramCustomer
     */
    @Transactional
    public void addNewCustomer(Customer paramCustomer) {
        Customer customer = new Customer();
        customer.setCustomer_Name(paramCustomer.getCustomer_Name());
        customer.setBank_Name(paramCustomer.getBank_Name());
        customer.setCustomer_Address(paramCustomer.getCustomer_Address());
        customer.setCustomer_PinCode(paramCustomer.getCustomer_PinCode());
        paramCustomer.getCustomer_accountsList().stream().forEach(paramAccount ->{
            Customer_Account account = new Customer_Account();
            account.setAccount_Number(paramAccount.getAccount_Number());
            account.setAccount_Type(paramAccount.getAccount_Type());
            account.setAvailable_Balance(paramAccount.getAvailable_Balance());
            Card card = new Card();
            card.setCardNo(paramAccount.getCard().getCardNo());
            card.setCardPin(paramAccount.getCard().getCardPin());
            account.addCard(card);
            customer.addCustomerAccount(account);
        });
        log.info("The Customer Details to be saved--{}",customer);
        customerRepositories.save(customer);
    }


    /**
     * This method is used for Testing and should not be used
     *
     * @return
     */
    @Transactional
    public Customer addDefaultCustomer() {
        Customer customer = new Customer();
        customer.setCustomer_Name("Amit");
        customer.setBank_Name("HDFC");
        customer.setCustomer_Address("T1 401 SPP");
        customer.setCustomer_PinCode(560068);
        customer.addCustomerAccount(getCustomerAccounts());
        customerRepositories.save(customer);
        return customer;
    }

    private Customer_Account getCustomerAccounts() {
        Customer_Account account = new Customer_Account();
        account.setAccount_Number("A01234");
        account.setAccount_Type("SAVINGS");
        account.setAvailable_Balance(20000);
        account.addCard(fetchCardDetails());
        return account;
    }

    private Card fetchCardDetails() {
        Card card = new Card();
        card.setCardNo("A1234 1456 1111 1212");
        card.setCardPin("2121");

        return card;
    }
}
