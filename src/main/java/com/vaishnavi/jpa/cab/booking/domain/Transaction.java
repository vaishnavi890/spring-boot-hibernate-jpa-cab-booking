package com.vaishnavi.jpa.cab.booking.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    private int paymentId;
    private double amount;
    private String transactionDate;
    private String transactionType;

    public Transaction(int paymentId, double amount, String transactionDate, String transactionType) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
    }
}
