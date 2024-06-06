package com.system.design.bankingService.customer.controllers;


import com.system.design.bankingService.customer.service.TransactionService;
import com.system.design.bankingService.customer.utils.ATMResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/transaction")
@Slf4j
public class CustomerTransaction {

    @Autowired
    TransactionService transactionService;


    @GetMapping("/checkBalance")
    public ResponseEntity<ATMResponse> checkBalance(@RequestParam String cardNo,@RequestParam String cardPin){
        log.info("Requesting check Balance for card NO {}", cardNo);
        ATMResponse atmResponse = transactionService.checkAccountBalance(cardNo,cardPin);
        return  ResponseEntity.ok(atmResponse);
    }

    @GetMapping("/withdrawCash")
    public ResponseEntity<ATMResponse>  withdrawCash(@RequestParam String cardNo,@RequestParam String cardPin,
                                                     @RequestParam double withDrawAmount){
        log.info("Requesting withdraw amount {} from card No --{}", cardNo ,withDrawAmount);
        ATMResponse atmResponse = transactionService.withdrawCash(cardNo,cardPin, withDrawAmount);
        return  ResponseEntity.ok(atmResponse);
    }

}
