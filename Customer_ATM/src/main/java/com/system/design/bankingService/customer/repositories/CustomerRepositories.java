package com.system.design.bankingService.customer.repositories;

import com.system.design.bankingService.customer.domain.Customer;
import com.system.design.bankingService.customer.domain.Customer_Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositories extends JpaRepository<Customer, Integer> {
}
