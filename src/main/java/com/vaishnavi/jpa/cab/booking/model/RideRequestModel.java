package com.vaishnavi.jpa.cab.booking.model;

import lombok.Data;

@Data
public class RideRequestModel {
    private int requestId;
    private int userId;
    private String pickupLocation;
    private String dropoffLocation;
    private String status;
}


