package com.system.design.bankingService.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * This application is used to add Customer Details
 * & provide a window to interact with ATM Service
 * Main method for the application of Customer
 * Swagger  link  : http://localhost:8084/customer/swagger-ui/index.html
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class ATMCustomerAppStartup {
    public static void main(String[] args) {
        log.info("******Starting the ATM Customer App******");
        SpringApplication.run(ATMCustomerAppStartup.class);
        log.info("******Started the ATM Customer App******");
    }
}