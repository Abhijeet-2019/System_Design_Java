package com.system.design.bankingService.ATM.util;

public class Operation {
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
