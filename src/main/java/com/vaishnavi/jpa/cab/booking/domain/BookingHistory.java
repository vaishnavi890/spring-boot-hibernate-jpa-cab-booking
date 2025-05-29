package com.vaishnavi.jpa.cab.booking.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "BookingHistory")
public class BookingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historyId;

    private int userId;
    private int rideId;
    private String bookingDate;
    private String status;

    public BookingHistory(int userId, int rideId, String bookingDate, String status) {
        this.userId = userId;
        this.rideId = rideId;
        this.bookingDate = bookingDate;
        this.status = status;
    }
}


