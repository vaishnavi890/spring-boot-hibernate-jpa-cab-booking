package com.vaishnavi.jpa.cab.booking.service.impl;

import com.vaishnavi.jpa.cab.booking.domain.Ride;
import com.vaishnavi.jpa.cab.booking.model.RideModel;
import com.vaishnavi.jpa.cab.booking.repository.RideRepository;
import com.vaishnavi.jpa.cab.booking.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("rideService")
public class RideServiceImpl implements RideService {

    @Autowired
    private RideRepository rideRepository;

    @Override
    public RideModel saveRide(RideModel model) {
        Ride ride = populateRideEntity(model);
        return populateRideModel(rideRepository.save(ride));
    }

    @Override
    public boolean deleteRide(Long rideId) {
        rideRepository.deleteById(rideId);
        return true;
    }

    @Override
    public List<RideModel> getAllRides() {
        List<RideModel> models = new ArrayList<>();
        rideRepository.findAll().forEach(ride -> models.add(populateRideModel(ride)));
        return models;
    }

    @Override
    public RideModel getRideById(Long rideId) {
        return populateRideModel(rideRepository.findById(rideId)
                .orElseThrow(() -> new EntityNotFoundException("Ride not found")));
    }

    private RideModel populateRideModel(Ride ride) {
        RideModel model = new RideModel();
        model.setId(ride.getId());
        model.setUserId(ride.getUserId());
        model.setDriverId(ride.getDriverId());
        model.setPickupLocation(ride.getPickupLocation());
        model.setDropoffLocation(ride.getDropoffLocation());
        model.setFare(ride.getFare());
        model.setStatus(ride.getStatus());
        return model;
    }

    private Ride populateRideEntity(RideModel model) {
        Ride ride = new Ride();
        ride.setUserId(model.getUserId());
        ride.setDriverId(model.getDriverId());
        ride.setPickupLocation(model.getPickupLocation());
        ride.setDropoffLocation(model.getDropoffLocation());
        ride.setFare(model.getFare());
        ride.setStatus(model.getStatus());
        return ride;
    }
}


