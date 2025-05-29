package com.vaishnavi.jpa.cab.booking.model;

import lombok.Data;

@Data
public class DriverModel {
    private int driverId;
    private String name;
    private String email;
    private String phone;
    private CabModel cabDetails;
}


