package com.system.design.bankingService.customer.utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("atm")
public interface BankAtmCommunication {
    @GetMapping("/services/withdrawCashFromATM/{customerId}/{accountId}/{withdrawAmount}")
    public ResponseEntity<String> withdrawFromAccount(@PathVariable("customerId") String customerId,
                                                      @PathVariable("accountId") String accountId,
                                                      @PathVariable("withdrawAmount") String withdrawAmount);
}
