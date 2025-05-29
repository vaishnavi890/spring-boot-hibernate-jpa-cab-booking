package com.vaishnavi.jpa.cab.booking.controller;

import com.vaishnavi.jpa.cab.booking.model.RideRequestModel;
import com.vaishnavi.jpa.cab.booking.service.RideRequestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rideRequestManagement")
public class RideRequestController {

    @Resource(name = "rideRequestService")
    private RideRequestService rideRequestService;

    @GetMapping("/requests")
    public List<RideRequestModel> getAllRideRequests() {
        return rideRequestService.getAllRideRequests();
    }

    @GetMapping("/request/{id}")
    public RideRequestModel getRideRequestById(@PathVariable int id) {
        return rideRequestService.getRideRequestById((long) id);
    }

    @PostMapping("/request")
    public RideRequestModel saveRideRequest(@RequestBody RideRequestModel requestModel) {
        return rideRequestService.saveRideRequest(requestModel);
    }

    @DeleteMapping("/request/{id}")
    public boolean deleteRideRequest(@PathVariable int id) {
        return rideRequestService.deleteRideRequest((long) id);
    }
}


