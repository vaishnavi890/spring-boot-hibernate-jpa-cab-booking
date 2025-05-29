package com.vaishnavi.jpa.cab.booking.model;

import lombok.Data;

@Data
public class PaymentModel {
    private int paymentId;
    private int rideId;
    private int userId;
    private double amount;
    private String paymentMethod;
    private String status;
}



