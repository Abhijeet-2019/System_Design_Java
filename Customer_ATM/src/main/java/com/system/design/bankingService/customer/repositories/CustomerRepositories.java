package com.system.design.bankingService.customer.repositories;

import com.system.design.bankingService.customer.domain.Customer;
import com.system.design.bankingService.customer.domain.Customer_Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepositories extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c JOIN c.customer_accountsList a JOIN a.card cc WHERE cc.cardNo = :cardNo " +
            "and cc.cardPin =:cardPin ")
    public Customer findByCustomerCardNumber(@Param("cardNo") String cardNo, @Param("cardPin") String cardPin);

}