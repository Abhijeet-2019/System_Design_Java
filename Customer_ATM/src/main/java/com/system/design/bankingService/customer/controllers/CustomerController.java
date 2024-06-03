package com.system.design.bankingService.customer.controllers;

import com.system.design.bankingService.customer.domain.Customer;
import com.system.design.bankingService.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/addDummyCustomer")
    public ResponseEntity<Customer> addCustomerDetails(){
        log.info("Adding a new Customer");
        return ResponseEntity.ok(customerService.addDefaultCustomer());
    }

    /**
     * Add a new Customer by details provided by the Customer.
     * @param customer
     * @return
     */
    @PostMapping("/addNewCustomer")
    public ResponseEntity<String> addNewCustomer(@RequestBody Customer customer){
        log.info("Adding a new Customer"+customer);
        try {
            customerService.addNewCustomer(customer);
        }catch (Exception e){
            log.error(e.toString());
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok("Successfully saved the Customer");
    }
    @GetMapping("/check")
    public ResponseEntity<String> checkServices(){
        return ResponseEntity.ok("Working");
    }
}
