package com.vaishnavi.jpa.cab.booking.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    private int rideId;
    private int userId;

    private double amount;
    private String paymentMethod;
    private String status;

    public Payment(int rideId, int userId, double amount, String paymentMethod, String status) {
        this.rideId = rideId;
        this.userId = userId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }
}

