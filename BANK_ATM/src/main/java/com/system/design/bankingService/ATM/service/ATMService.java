package com.system.design.bankingService.ATM.service;

import com.system.design.bankingService.ATM.Repository.ATMRepository;
import com.system.design.bankingService.ATM.domain.ATM;
import com.system.design.bankingService.ATM.domain.ATMTransaction;
import com.system.design.bankingService.ATM.util.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ATMService {

    @Autowired
    private ATMRepository atmRepository;

    public void depositCashInATM(ATM parmaAtmCash) {
        ATM atmCash = new ATM();
        atmCash.setAtm_Name(parmaAtmCash.getAtm_Name());
        atmCash.setAtm_Address(parmaAtmCash.getAtm_Address());
        atmCash.setAtm_PinCode(parmaAtmCash.getAtm_PinCode());
        atmCash.setAvailable_Balance(parmaAtmCash.getAvailable_Balance());
        atmCash.setDay_AmountDeposit(parmaAtmCash.getDay_AmountDeposit());
        atmCash.setNo_100_Available(parmaAtmCash.getNo_100_Available());
        atmCash.setNo_500_Available(parmaAtmCash.getNo_500_Available());
        atmCash.setAmountDepositDate(parmaAtmCash.getAmountDepositDate());
        atmCash.setDeposit_Status(Operation.Statuses.SUCCESS.name());

        ATMTransaction atmTrans = new ATMTransaction();
        atmTrans.setCustomerId(parmaAtmCash.getAtmTransaction().getCustomerId());
        atmTrans.setAmount(parmaAtmCash.getAtmTransaction().getAmount());
        atmTrans.setTransactionType(parmaAtmCash.getAtmTransaction().getTransactionType());
        atmCash.addTransaction(atmTrans);

        atmRepository.save(atmCash);
    }

}
