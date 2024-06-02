package com.system.design.bankingService.customer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ACCOUNT_CARD")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "card_generator")
    @SequenceGenerator(name = "card_generator",
            sequenceName = "card_sequence",
            allocationSize = 1)
    @Column(name = "CARD_ID")
    private int cardId;

    @Column(name = "CARD_NUMBER")
    private String cardNo;

    @Column(name = "CARD_PIN")
    private String cardPin;


    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private Customer_Account customer_account;

    @OneToOne(mappedBy = "card" , fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private CardTransaction cardTransaction;

    public void addTransaction(CardTransaction cardTransaction){
        cardTransaction.setCard(this);
        this.setCardTransaction(cardTransaction);
    }
}
