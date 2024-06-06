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
}
