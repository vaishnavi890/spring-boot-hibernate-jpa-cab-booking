package com.vaishnavi.jpa.cab.booking.model;

import lombok.Data;

@Data
public class BookingHistoryModel {
    private int historyId;
    private int userId;
    private int rideId;
    private String bookingDate;
    private String status;
}



