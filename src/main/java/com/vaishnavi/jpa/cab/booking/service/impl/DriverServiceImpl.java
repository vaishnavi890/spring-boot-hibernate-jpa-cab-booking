package com.vaishnavi.jpa.cab.booking.service.impl;

import com.vaishnavi.jpa.cab.booking.domain.Driver;
import com.vaishnavi.jpa.cab.booking.model.DriverModel;
import com.vaishnavi.jpa.cab.booking.repository.DriverRepository;
import com.vaishnavi.jpa.cab.booking.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("driverService")
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public DriverModel saveDriver(DriverModel model) {
        Driver driver = populateDriverEntity(model);
        return populateDriverModel(driverRepository.save(driver));
    }

    @Override
    public boolean deleteDriver(Long driverId) {
        driverRepository.deleteById(driverId);
        return true;
    }

    @Override
    public List<DriverModel> getAllDrivers() {
        List<DriverModel> drivers = new ArrayList<>();
        List<Driver> driverList = driverRepository.findAll();
        driverList.forEach(driver -> drivers.add(populateDriverModel(driver)));
        return drivers;
    }

    @Override
    public DriverModel getDriverById(Long driverId) {
        return populateDriverModel(driverRepository.findById(driverId)
                .orElseThrow(() -> new EntityNotFoundException("Driver not found")));
    }

    private DriverModel populateDriverModel(final Driver driver) {
        DriverModel model = new DriverModel();
        model.setId(driver.getId());
        model.setName(driver.getName());
        model.setEmail(driver.getEmail());
        model.setPhone(driver.getPhone());
        model.setCabDetails(driver.getCabDetails());
        return model;
    }

    private Driver populateDriverEntity(DriverModel model) {
        Driver driver = new Driver();
        driver.setName(model.getName());
        driver.setEmail(model.getEmail());
        driver.setPhone(model.getPhone());
        driver.setCabDetails(model.getCabDetails());
        return driver;
    }
}


