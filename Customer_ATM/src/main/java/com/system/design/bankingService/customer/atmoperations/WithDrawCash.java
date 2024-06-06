package com.system.design.bankingService.customer.atmoperations;

import com.system.design.bankingService.customer.domain.Customer;
import org.springframework.stereotype.Service;

@Service("WithDrawCash")
public class WithDrawCash implements AtmOperations {
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
        return null;
    }

    @Override
    public void cancelOperation() {

    }

    @Override
    public void exitAndReturnCard() {

    }
}
