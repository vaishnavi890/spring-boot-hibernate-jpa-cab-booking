package com.vaishnavi.jpa.cab.booking.service.impl;

import com.vaishnavi.jpa.cab.booking.domain.Location;
import com.vaishnavi.jpa.cab.booking.model.LocationModel;
import com.vaishnavi.jpa.cab.booking.repository.LocationRepository;
import com.vaishnavi.jpa.cab.booking.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("locationService")
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationModel saveLocation(LocationModel model) {
        Location location = populateLocationEntity(model);
        return populateLocationModel(locationRepository.save(location));
    }

    @Override
    public boolean deleteLocation(Long locationId) {
        locationRepository.deleteById(locationId);
        return true;
    }

    @Override
    public List<LocationModel> getAllLocations() {
        List<LocationModel> models = new ArrayList<>();
        locationRepository.findAll().forEach(loc -> models.add(populateLocationModel(loc)));
        return models;
    }

    @Override
    public LocationModel getLocationById(Long locationId) {
        return populateLocationModel(locationRepository.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException("Location not found")));
    }

    private LocationModel populateLocationModel(Location location) {
        LocationModel model = new LocationModel();
        model.setId(location.getId());
        model.setLatitude(location.getLatitude());
        model.setLongitude(location.getLongitude());
        model.setAddress(location.getAddress());
        return model;
    }

    private Location populateLocationEntity(LocationModel model) {
        Location location = new Location();
        location.setLatitude(model.getLatitude());
        location.setLongitude(model.getLongitude());
        location.setAddress(model.getAddress());
        return location;
    }
}

