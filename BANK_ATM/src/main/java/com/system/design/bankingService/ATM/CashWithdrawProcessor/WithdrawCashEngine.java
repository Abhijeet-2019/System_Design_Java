package com.system.design.bankingService.ATM.CashWithdrawProcessor;

import com.system.design.bankingService.ATM.domain.ATM;
import com.system.design.bankingService.ATM.util.AtmOperation;

public abstract class WithdrawCashEngine {

    private WithdrawCashEngine nexWithdrawEngine;

//    private ATMRepository atmRepository = nulll;
    public WithdrawCashEngine( WithdrawCashEngine nextWirhdrawEngine){
        this.nexWithdrawEngine = nexWithdrawEngine;
    }
    public abstract  void  withdraw( int withdrawAmount, ATM atmRepository) throws Exception;

    public  boolean isCurrencyAvailableInATM(int currencyValue ,ATM atmObject){
        if(currencyValue == AtmOperation.CURRENCY_NOTES.FIVE_HUNDRED.getNumVal()){
            return atmObject.getNo_500_Available() > 0;
        }else if(currencyValue == AtmOperation.CURRENCY_NOTES.TWO_HUNDRED.getNumVal()){
            System.out.println("atmObject.getNo_200_Available() > 0");
            return atmObject.getNo_200_Available() >  0;
        }else if(currencyValue == AtmOperation.CURRENCY_NOTES.ONE_HUNDRED.getNumVal()){
            return atmObject.getNo_100_Available() > 0;
        }
        return false;
    }


}
