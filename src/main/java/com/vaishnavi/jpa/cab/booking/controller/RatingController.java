package com.vaishnavi.jpa.cab.booking.controller;

import com.vaishnavi.jpa.cab.booking.model.RatingModel;
import com.vaishnavi.jpa.cab.booking.service.RatingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ratingManagement")
public class RatingController {

    @Resource(name = "ratingService")
    private RatingService ratingService;

    @GetMapping("/ratings")
    public List<RatingModel> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping("/rating/{id}")
    public RatingModel getRatingById(@PathVariable Long id) {
        return ratingService.getRatingById(id);
    }

    @PostMapping("/rating")
    public RatingModel saveRating(@RequestBody RatingModel ratingModel) {
        return ratingService.saveRating(ratingModel);
    }

    @DeleteMapping("/rating/{id}")
    public boolean deleteRating(@PathVariable Long id) {
        return ratingService.deleteRating(id);
    }
}


