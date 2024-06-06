package com.system.design.bankingService.customer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "customer_generator")
    @SequenceGenerator(name = "customer_generator",
            sequenceName = "customer_sequence",
            allocationSize = 1)
    @Column(name = "CUSTOMER_ID")
    private int customer_ID;

    @Column(name = "CUSTOMER_NAME")
    private String customer_Name;

    @Column(name = "BANK_NAME")
    private String bank_Name;

    @Column(name = "CUSTOMER_ADDRESS")
    private String customer_Address;

    @Column(name = "CUSTOMER_PINCODE")
    private int customer_PinCode;

    @Transient
    private boolean isAuthenticated;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Customer_Account> customer_accountsList;


    public void addCustomerAccount(Customer_Account customer_account) {
        if(customer_accountsList == null ){
            customer_accountsList = new ArrayList<>();
        }
        customer_accountsList.add(customer_account);
        customer_account.setCustomer(this);
    }
}
