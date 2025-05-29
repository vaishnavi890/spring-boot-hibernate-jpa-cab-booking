package com.vaishnavi.jpa.cab.booking.service.impl;

import com.vaishnavi.jpa.cab.booking.domain.Rating;
import com.vaishnavi.jpa.cab.booking.model.RatingModel;
import com.vaishnavi.jpa.cab.booking.repository.RatingRepository;
import com.vaishnavi.jpa.cab.booking.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("ratingService")
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public RatingModel saveRating(RatingModel model) {
        Rating rating = populateRatingEntity(model);
        return populateRatingModel(ratingRepository.save(rating));
    }

    @Override
    public boolean deleteRating(Long ratingId) {
        ratingRepository.deleteById(ratingId);
        return true;
    }

    @Override
    public List<RatingModel> getAllRatings() {
        List<RatingModel> models = new ArrayList<>();
        ratingRepository.findAll().forEach(rating -> models.add(populateRatingModel(rating)));
        return models;
    }

    @Override
    public RatingModel getRatingById(Long ratingId) {
        return populateRatingModel(ratingRepository.findById(ratingId)
                .orElseThrow(() -> new EntityNotFoundException("Rating not found")));
    }

    private RatingModel populateRatingModel(Rating rating) {
        RatingModel model = new RatingModel();
        model.setId(rating.getId());
        model.setRideId(rating.getRideId());
        model.setUserId(rating.getUserId());
        model.setDriverId(rating.getDriverId());
        model.setRating(rating.getRating());
        model.setReview(rating.getReview());
        return model;
    }

    private Rating populateRatingEntity(RatingModel model) {
        Rating rating = new Rating();
        rating.setRideId(model.getRideId());
        rating.setUserId(model.getUserId());
        rating.setDriverId(model.getDriverId());
        rating.setRating(model.getRating());
        rating.setReview(model.getReview());
        return rating;
    }
}


