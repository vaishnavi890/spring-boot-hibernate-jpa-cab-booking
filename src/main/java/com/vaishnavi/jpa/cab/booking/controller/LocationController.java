package com.vaishnavi.jpa.cab.booking.controller;

import com.vaishnavi.jpa.cab.booking.model.LocationModel;
import com.vaishnavi.jpa.cab.booking.service.LocationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/locationManagement")
public class LocationController {

    @Resource(name = "locationService")
    private LocationService locationService;

    @GetMapping("/locations")
    public List<LocationModel> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/location/{id}")
    public LocationModel getLocationById(@PathVariable int id) {
        return locationService.getLocationById(id);
    }

    @PostMapping("/location")
    public LocationModel saveLocation(@RequestBody LocationModel locationModel) {
        return locationService.saveLocation(locationModel);
    }

    @DeleteMapping("/location/{id}")
    public boolean deleteLocation(@PathVariable int id) {
        return locationService.deleteLocation(id);
    }
}



