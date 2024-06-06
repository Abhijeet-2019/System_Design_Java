package com.system.design.bankingService.ATM.service;

import com.system.design.bankingService.ATM.CashWithdrawProcessor.Five00WithDrawCashEngine;
import com.system.design.bankingService.ATM.CashWithdrawProcessor.HundredWithDrawCashEngine;
import com.system.design.bankingService.ATM.CashWithdrawProcessor.TwoHundredWithdrawCashEngine;
import com.system.design.bankingService.ATM.CashWithdrawProcessor.WithdrawCashEngine;
import com.system.design.bankingService.ATM.Repository.ATMRepository;
import com.system.design.bankingService.ATM.domain.ATM;
import com.system.design.bankingService.ATM.domain.ATMTransaction;
import com.system.design.bankingService.ATM.util.AtmOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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
        atmCash.setDeposit_Status(AtmOperation.Statuses.SUCCESS.name());

        ATMTransaction atmTrans = new ATMTransaction();
        atmTrans.setCustomerId(parmaAtmCash.getAtmTransaction().getCustomerId());
        atmTrans.setAmount(parmaAtmCash.getAtmTransaction().getAmount());
        atmTrans.setTransactionType(parmaAtmCash.getAtmTransaction().getTransactionType());
        atmCash.addTransaction(atmTrans);
        atmRepository.save(atmCash);
    }

    public void withdrawCashFromAccount(String customerId, String accountId, int withdrawAmount) throws Exception {

        ATM atmObject =   atmRepository.findbyAtm_Id(3);
       int cashAvailableATM =  atmObject.getAvailable_Balance();
        if(withdrawAmount >= cashAvailableATM){
        log.info("There is no Sufficient funds in ATM");
            return;
        }else {
            //using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes etc, has to be withdrawal
            WithdrawCashEngine withdrawProcessor =
                    new Five00WithDrawCashEngine(
                            new TwoHundredWithdrawCashEngine(
                                    new HundredWithDrawCashEngine(null)));
            withdrawProcessor.withdraw(withdrawAmount , atmObject);

        }
    }
}
