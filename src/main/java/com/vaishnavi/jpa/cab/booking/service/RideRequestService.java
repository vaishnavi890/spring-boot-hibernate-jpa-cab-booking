package com.vaishnavi.jpa.cab.booking.service;

import com.vaishnavi.jpa.cab.booking.model.RideRequestModel;
import java.util.List;

public interface RideRequestService {
    RideRequestModel createRequest(RideRequestModel request);
    boolean deleteRequest(int requestId);
    List<RideRequestModel> getAllRequests();
    RideRequestModel getRequestById(int requestId);
    RideRequestModel updateRequestStatus(int requestId, String status);

    RideRequestModel saveRideRequest(RideRequestModel model);

    boolean deleteRideRequest(Long requestId);

    List<RideRequestModel> getAllRideRequests();

    RideRequestModel getRideRequestById(Long requestId);
}


