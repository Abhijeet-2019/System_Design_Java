package com.system.design.bankingService.ATM.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.EnableCaching;

@Entity
@Getter
@Setter
@Table(name="ATM_TRANSACTION")
public class ATMTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "atmSeq_generator")
    @SequenceGenerator(name = "atmSeq_generator",
            sequenceName = "atm_sequence",
            allocationSize = 1)

    @Column(name = "ATM_TRANS_ID")
    private int atmTranId;

    @Column(name = "CUSTOMER_ID")
    private int customerId;

    @Column(name = "ACCOUNT_ID")
    private int accountId;

    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;

    @Column(name = "AMOUNT")
    private int amount;


    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ATM_ID")
    private ATM atm;
}
