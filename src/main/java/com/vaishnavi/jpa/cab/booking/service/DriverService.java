package com.vaishnavi.jpa.cab.booking.service;

import com.vaishnavi.jpa.cab.booking.model.DriverModel;
import java.util.List;

public interface DriverService {
    DriverModel saveDriver(DriverModel driver);
    boolean deleteDriver(int driverId);

    boolean deleteDriver(Long driverId);

    List<DriverModel> getAllDrivers();
    DriverModel getDriverById(int driverId);

    DriverModel getDriverById(Long driverId);
}


