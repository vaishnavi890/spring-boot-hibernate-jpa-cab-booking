package com.vaishnavi.jpa.cab.booking.model;

import lombok.Data;

@Data
public class LocationModel {
    private int locationId;
    private String address;
    private String city;
    private String state;
    private String zipCode;
}



