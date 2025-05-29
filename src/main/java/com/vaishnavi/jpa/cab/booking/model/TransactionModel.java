package com.vaishnavi.jpa.cab.booking.model;

import lombok.Data;

@Data
public class TransactionModel {
    private int transactionId;
    private int paymentId;
    private double amount;
    private String transactionDate;
    private String transactionType;
}


