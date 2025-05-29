package com.vaishnavi.jpa.cab.booking.service;

import com.vaishnavi.jpa.cab.booking.model.RideModel;
import java.util.List;

public interface RideService {
    RideModel bookRide(RideModel ride);
    boolean deleteRide(int rideId);

    RideModel saveRide(RideModel model);

    boolean deleteRide(Long rideId);

    List<RideModel> getAllRides();
    RideModel getRideById(int rideId);
    RideModel updateRideStatus(int rideId, String status);

    RideModel getRideById(Long rideId);
}


