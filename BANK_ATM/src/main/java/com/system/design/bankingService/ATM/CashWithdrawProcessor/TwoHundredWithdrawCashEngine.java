package com.system.design.bankingService.ATM.CashWithdrawProcessor;

import com.system.design.bankingService.ATM.domain.ATM;
import com.system.design.bankingService.ATM.util.AtmOperation;

public class TwoHundredWithdrawCashEngine extends WithdrawCashEngine {

    private WithdrawCashEngine nextWithdrawEngine = null;

    public TwoHundredWithdrawCashEngine(WithdrawCashEngine nextWirhdrawEngine) {
        super(nextWirhdrawEngine);
        this.nextWithdrawEngine = nextWirhdrawEngine;
    }

    @Override
    public void withdraw( int withdrawAmount , ATM atmObject) throws Exception {
        System.out.println("HI i am withdrawing TWO Hundred");

        int twoHundredNumVal =AtmOperation.CURRENCY_NOTES.TWO_HUNDRED.getNumVal();
        if(withdrawAmount>=twoHundredNumVal){
            int requiredNotes =  withdrawAmount/twoHundredNumVal;
            int balanceNotes = withdrawAmount%twoHundredNumVal;
            System.out.println("required-----"+requiredNotes+"------balance----"+balanceNotes);
            if(balanceNotes == 0){
                boolean isCurrencyAvailable = super.isCurrencyAvailableInATM(twoHundredNumVal, atmObject);
                if(isCurrencyAvailable) {
                    return;
                }else{
                    nextWithdrawEngine.withdraw(withdrawAmount, atmObject);
                }
            }else {
                nextWithdrawEngine.withdraw(balanceNotes, atmObject);
            }
        }else {
            nextWithdrawEngine.withdraw(withdrawAmount, atmObject);
        }
    }
}
