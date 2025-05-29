package com.vaishnavi.jpa.cab.booking.service;

import com.vaishnavi.jpa.cab.booking.model.LocationModel;
import java.util.List;

public interface LocationService {
    LocationModel saveLocation(LocationModel location);
    boolean deleteLocation(int locationId);

    boolean deleteLocation(Long locationId);

    List<LocationModel> getAllLocations();
    LocationModel getLocationById(int locationId);

    LocationModel getLocationById(Long locationId);
}

