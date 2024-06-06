package com.system.design.bankingService.customer.atmoperations;


import com.system.design.bankingService.customer.domain.Customer;
import com.system.design.bankingService.customer.repositories.CustomerRepositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AuthenticateUser")
@Slf4j
public class AuthenticateUser implements AtmOperations{

    @Autowired
    private CustomerRepositories customerRepositories;

    @Override
    public Object performATMOperation(String cardNO, String cardPin, Customer customer) {
        log.info(" Authenticating the details of the user-- {}",cardNO );
       Customer repositoryCustomer  = customerRepositories.findByCustomerCardNumber(cardNO,cardPin);
       if(repositoryCustomer != null){
           log.info("Customer validation success for Card No {}", cardNO);
           repositoryCustomer.setAuthenticated(true);
       }else {
           repositoryCustomer = new Customer();
           log.info("Customer validation failed for Card No {}", cardNO);
           repositoryCustomer.setAuthenticated(false);
       }
       return repositoryCustomer;
    }

    @Override
    public void cancelOperation() {
        log.info("Exit and Return the card-- ");
    }

    @Override
    public void exitAndReturnCard() {
        log.info("Exit and Return the card-- ");
    }
}
