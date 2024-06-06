package com.system.design.bankingService.ATM.CashWithdrawProcessor;

import com.system.design.bankingService.ATM.Repository.ATMRepository;
import com.system.design.bankingService.ATM.domain.ATM;
import com.system.design.bankingService.ATM.util.AtmOperation;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HundredWithDrawCashEngine extends WithdrawCashEngine{


    public HundredWithDrawCashEngine(WithdrawCashEngine nextWirhdrawEngine) {
        super(nextWirhdrawEngine);
    }

    @Override
    public void withdraw( int withdrawAmount,  ATM atmObject) throws Exception {
        log.info("Checking if amount can be withdrawn using 100 notes");
        int oneHundredNoteValue = AtmOperation.CURRENCY_NOTES.ONE_HUNDRED.getNumVal();
            if(withdrawAmount>=oneHundredNoteValue) {
            int requiredNotes = withdrawAmount / oneHundredNoteValue;
            int balanceNotes = withdrawAmount % oneHundredNoteValue;
            log.info("required--100 Notes---{} and ------balance  amount----{}",requiredNotes , balanceNotes);
            if (balanceNotes == 0) {
                boolean isCurrencyAvailable = super.isCurrencyAvailableInATM(oneHundredNoteValue, atmObject);
                if(isCurrencyAvailable) {
                    return;
                }else{
                  throw new Exception("Amount entered is not valid");
                }
            }
        }
            throw new Exception("Amount entered is not valid");
    }

}
