package com.vaishnavi.jpa.cab.booking.service;

import com.vaishnavi.jpa.cab.booking.model.RatingModel;
import java.util.List;

public interface RatingService {
    RatingModel rateDriver(RatingModel rating);
    boolean deleteRating(int ratingId);

    RatingModel saveRating(RatingModel model);

    boolean deleteRating(Long ratingId);

    List<RatingModel> getAllRatings();
    RatingModel getRatingById(int ratingId);

    RatingModel getRatingById(Long ratingId);
}


