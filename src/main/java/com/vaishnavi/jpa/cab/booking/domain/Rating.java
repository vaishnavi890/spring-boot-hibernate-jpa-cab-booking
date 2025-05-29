package com.vaishnavi.jpa.cab.booking.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "Rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratingId;

    private int rideId;
    private int userId;
    private int driverId;

    private int rating;
    private String review;

    public Rating(int rideId, int userId, int driverId, int rating, String review) {
        this.rideId = rideId;
        this.userId = userId;
        this.driverId = driverId;
        this.rating = rating;
        this.review = review;
    }
}


