package com.system.design.bankingService.customer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CARD_TRANSACTION")
@Getter
@Setter
public class CardTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator ="cardTransaction_generator")
    @SequenceGenerator(name = "cardTransaction_generator",
            sequenceName = "cardTran_sequence",
            allocationSize = 1)
    @Column(name = "TRANSACTION_ID")
    private int transactionId;

    @Column(name = "TRANSACTION_TYPE")
    private String TransactionType;

    @Column(name = "AMOUNT")
    private int amount;

    @Column(name = "TRANSACTION_DATE")
    private Date transactionDate;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CARD_ID")
    private Card card;
}

