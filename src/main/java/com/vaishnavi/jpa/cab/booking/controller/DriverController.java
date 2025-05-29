package com.vaishnavi.jpa.cab.booking.controller;

import com.vaishnavi.jpa.cab.booking.model.DriverModel;
import com.vaishnavi.jpa.cab.booking.service.DriverService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/driverManagement")
public class DriverController {

    @Resource(name = "driverService")
    private DriverService driverService;

    @GetMapping("/drivers")
    public List<DriverModel> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/driver/{id}")
    public DriverModel getDriverById(@PathVariable Long id) {
        return driverService.getDriverById(id);
    }

    @PostMapping("/driver")
    public DriverModel saveDriver(@RequestBody DriverModel driverModel) {
        return driverService.saveDriver(driverModel);
    }

    @DeleteMapping("/driver/{id}")
    public boolean deleteDriver(@PathVariable Long id) {
        return driverService.deleteDriver(id);
    }
}


