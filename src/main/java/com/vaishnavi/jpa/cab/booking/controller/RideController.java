package com.vaishnavi.jpa.cab.booking.controller;

import com.vaishnavi.jpa.cab.booking.model.RideModel;
import com.vaishnavi.jpa.cab.booking.service.RideService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rideManagement")
public class RideController {

    @Resource(name = "rideService")
    private RideService rideService;

    @GetMapping("/rides")
    public List<RideModel> getAllRides() {
        return rideService.getAllRides();
    }

    @GetMapping("/ride/{id}")
    public RideModel getRideById(@PathVariable Long id) {
        return rideService.getRideById(id);
    }

    @PostMapping("/ride")
    public RideModel saveRide(@RequestBody RideModel rideModel) {
        return rideService.saveRide(rideModel);
    }

    @DeleteMapping("/ride/{id}")
    public boolean deleteRide(@PathVariable Long id) {
        return rideService.deleteRide(id);
    }
}



