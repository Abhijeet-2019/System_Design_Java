package com.system.design.bankingService.customer.atmoperations;

import com.system.design.bankingService.customer.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public interface AtmOperations {

    public Object performATMOperation(String cardNO, String cardPin, Customer customer) ;
    public void cancelOperation();
    public void exitAndReturnCard();

}
