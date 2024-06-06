package com.system.design.bankingService.ATM.CashWithdrawProcessor;

import com.system.design.bankingService.ATM.domain.ATM;
import com.system.design.bankingService.ATM.util.AtmOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Five00WithDrawCashEngine extends WithdrawCashEngine {

    private WithdrawCashEngine nextWithdrawEngine = null;
    public Five00WithDrawCashEngine(WithdrawCashEngine nextWithdrawEngine) {
        super(nextWithdrawEngine);
        this.nextWithdrawEngine = nextWithdrawEngine;
    }

    @Override
    public void withdraw(int withdrawAmount, ATM atmObject) throws Exception{
        log.info("Checking if amount can be withdrawn using 500 notes");

        int fiveHundredValue = AtmOperation.CURRENCY_NOTES.FIVE_HUNDRED.getNumVal();
        if (withdrawAmount >= fiveHundredValue) {
            int requiredNotes = withdrawAmount / fiveHundredValue;
            int balanceNotes = withdrawAmount % fiveHundredValue;
            log.info("required--500 Notes---{} and ------balance  amount----{}",requiredNotes , balanceNotes);
            if (balanceNotes == 0) {
                boolean isCurrencyAvailable = super.isCurrencyAvailableInATM(fiveHundredValue, atmObject);
                    if(isCurrencyAvailable) {
                        return;
                    }else{
                        nextWithdrawEngine.withdraw(withdrawAmount, atmObject);
                    }
            } else {
                nextWithdrawEngine.withdraw(balanceNotes, atmObject);
            }
        } else {
            nextWithdrawEngine.withdraw(withdrawAmount, atmObject);
        }
    }
}
