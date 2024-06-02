package com.system.design.bankingService.customer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Getter
@Setter
@Entity
@Table(name = "CUST_ACCOUNTS")
public class Customer_Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "acc_generator")
    @SequenceGenerator(name = "acc_generator",
            sequenceName = "acc_sequence",
            allocationSize = 1)
    @Column(name = "ACCOUNT_ID")
    private int account_Id;

    @Column(name = "ACCOUNT_NUMBER")
    private String account_Number;

    @Column(name = "ACCOUNT_TYPE")
    private String account_Type;

    @Column(name = "AVAILABLE_BALANCE")
    private double available_Balance;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    @Fetch(FetchMode.JOIN)
    private Customer customer;


    @OneToOne(mappedBy = "customer_account", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Card card;

    public void addCard(Card card){
      card.setCustomer_account(this);
      this.setCard(card);
    }
}
