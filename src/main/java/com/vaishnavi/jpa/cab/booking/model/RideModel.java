package com.vaishnavi.jpa.cab.booking.model;

import lombok.Data;

@Data
public class RideModel {
    private int rideId;
    private int userId;
    private int driverId;
    private String pickupLocation;
    private String dropoffLocation;
    private double fare;
    private String status;
}

