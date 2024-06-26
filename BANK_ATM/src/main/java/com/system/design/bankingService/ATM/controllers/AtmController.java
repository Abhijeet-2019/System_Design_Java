package com.system.design.bankingService.ATM.controllers;


import com.system.design.bankingService.ATM.domain.ATM;
import com.system.design.bankingService.ATM.service.ATMService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/services")
public class AtmController {

    @Autowired
    private ATMService atmService;

    /**
     * Deposit the Cash from BANK
     * @param atm
     * @return
     */
    @PostMapping("/depositCashInAtm")
    public ResponseEntity<String> depositCashInATN(@RequestBody ATM atm){
        log.info("The cash deposited by Bank---"+atm);
        atmService.depositCashInATM(atm);
        return ResponseEntity.ok("Successfully saved the Customer");
    }

    @GetMapping("/checkStatus")
    public ResponseEntity<String> getATMStatus(){
        log.info("check the ATM Status");
        return ResponseEntity.ok("Working");
    }

    @GetMapping("/withdrawCashFromATM")
    public ResponseEntity<String> withdrawFromAccount(@RequestParam String customerId,
                @RequestParam String accountId, int withdrawAmount){
           try {
               atmService.withdrawCashFromAccount(customerId, accountId, withdrawAmount);
           }catch (Exception e){
               return ResponseEntity.ok("Cash Value enter is Invalid... Enter Correct amount");
           }
        return ResponseEntity.
                ok("Cash has been debited from account id "+accountId+" for Customer "+customerId);
    }
}
