package com.system.design.bankingService.customer.atmoperations;


import com.system.design.bankingService.customer.domain.Card;
import com.system.design.bankingService.customer.domain.Customer;
import com.system.design.bankingService.customer.domain.Customer_Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("CheckAccountBalance")
@Slf4j
public class CheckAccountBalance implements AtmOperations{
    @Override
    public Object performATMOperation(String cardNO, String cardPin, Customer customer) {
        final double[] cashAvailable = {0};
        customer.getCustomer_accountsList().stream().forEach(accont ->{
            Card card = accont.getCard();
            if(card.getCardNo().equalsIgnoreCase(cardNO)
                    && card.getCardPin().equals(cardPin)){
                log.info("The Customer cash Balance is {}", accont.getAvailable_Balance());
                cashAvailable[0] = cashAvailable[0] + accont.getAvailable_Balance();
            }
        });
        return cashAvailable[0];
    }

    @Override
    public void cancelOperation() {

    }

    @Override
    public void exitAndReturnCard() {

    }
}
