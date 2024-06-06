package com.system.design.bankingService.ATM.util;

public class AtmOperation {
    public enum Statuses{
        SUCCESS,
        FAILED,
        ON_HOLD
    }
    public enum Types{
        Deposit,
        Withdraw
    }
    public enum CURRENCY_NOTES {
        FIVE_HUNDRED(500),
        TWO_HUNDRED(200),
        ONE_HUNDRED(100);
        private int numVal;
        CURRENCY_NOTES(int numVal) {
            this.numVal = numVal;
        }
        public int getNumVal() {
            return numVal;
        }
    }
}
