package com.vaishnavi.jpa.cab.booking.model;

import lombok.Data;

@Data
public class RatingModel {
    private int ratingId;
    private int rideId;
    private int userId;
    private int driverId;
    private int rating;
    private String review;
}


