package com.vaishnavi.jpa.cab.booking.service.impl;

import com.vaishnavi.jpa.cab.booking.domain.RideRequest;
import com.vaishnavi.jpa.cab.booking.model.RideRequestModel;
import com.vaishnavi.jpa.cab.booking.repository.RideRequestRepository;
import com.vaishnavi.jpa.cab.booking.service.RideRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("rideRequestService")
public class RideRequestServiceImpl implements RideRequestService {

    @Autowired
    private RideRequestRepository rideRequestRepository;

    @Override
    public RideRequestModel saveRideRequest(RideRequestModel model) {
        RideRequest req = populateRideRequestEntity(model);
        return populateRideRequestModel(rideRequestRepository.save(req));
    }

    @Override
    public boolean deleteRideRequest(Long requestId) {
        rideRequestRepository.deleteById(requestId);
        return true;
    }

    @Override
    public List<RideRequestModel> getAllRideRequests() {
        List<RideRequestModel> models = new ArrayList<>();
        rideRequestRepository.findAll().forEach(req -> models.add(populateRideRequestModel(req)));
        return models;
    }

    @Override
    public RideRequestModel getRideRequestById(Long requestId) {
        return populateRideRequestModel(rideRequestRepository.findById(requestId)
                .orElseThrow(() -> new EntityNotFoundException("Ride Request not found")));
    }

    private RideRequestModel populateRideRequestModel(RideRequest req) {
        RideRequestModel model = new RideRequestModel();
        model.setId(req.getId());
        model.setUserId(req.getUserId());
        model.setPickupLocation(req.getPickupLocation());
        model.setDropoffLocation(req.getDropoffLocation());
        return model;
    }

    private RideRequest populateRideRequestEntity(RideRequestModel model) {
        RideRequest req = new RideRequest();
        req.setUserId(model.getUserId());
        req.setPickupLocation(model.getPickupLocation());
        req.setDropoffLocation(model.getDropoffLocation());
        return req;
    }
}
