package com.system.design.bankingService.ATM;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
@Slf4j
public class ATMMain {
    public static void main(String[] args) {
        log.info("******ATM Main Application******");
        SpringApplication.run(ATMMain.class);
        log.info("******Started the ATM Main Application******");

    }
}