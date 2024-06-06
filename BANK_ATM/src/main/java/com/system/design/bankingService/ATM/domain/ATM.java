package com.system.design.bankingService.ATM.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.sql.Timestamp;

@Entity
@Table
@Getter
@Setter
public class ATM {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "atmSeq_generator")
    @SequenceGenerator(name = "atmSeq_generator",
            sequenceName = "atm_sequence",
            allocationSize = 1)

    @Column(name = "ATM_ID")
    private int atm_Id;

    @Column(name = "ATM_NAME")
    private String atm_Name;

    @Column(name = "ATM_ADDRESS")
    private String atm_Address;

    @Column(name = "ATM_PINCODE")
    private String atm_PinCode;

    @Column(name = "AVAILABLE_BALANCE")
    private int available_Balance;

    @Column(name = "NO_OF_FIVE_HUNDRED_AVAILABLE")
    private int no_500_Available;

    @Column(name = "NO_OF_TWO_HUNDRED_AVAILABLE")
    private int no_200_Available;

    @Column(name = "NO_OF_ONE_HUNDRED_AVAILABLE")
    private int no_100_Available;

    @Column(name = "DAY_IN_AMOUNT_DEPOSITED")
    private int day_AmountDeposit;

    @Column(name = "AMOUNT_DEPOSIT_STATUS")
    private String deposit_Status;

    @Column(name = "LAST_ATM_DEPOSIT_DATE")
    private Timestamp amountDepositDate;

    @OneToOne(mappedBy = "atm", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private ATMTransaction atmTransaction;


    public void addTransaction(ATMTransaction atmTransaction){
        atmTransaction.setAtm(this);
        this.setAtmTransaction(atmTransaction);
    }
}
