package com.vaishnavi.jpa.cab.booking.model;

import lombok.Data;

@Data
public class CabModel {
    private int cabId;
    private String cabNumber;
    private String cabModel;
    private String cabType;
    private String licensePlate;
    private int driverId;
}



