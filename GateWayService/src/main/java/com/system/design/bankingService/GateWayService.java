package com.system.design.bankingService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * This is an API Gateway for the application
 *  Link for
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient

public class GateWayService {
    public static void main(String[] args) {
        SpringApplication.run(GateWayService.class);
    }
}