package com.example.letsgo.service;

import com.example.letsgo.entities.Driver;
import com.example.letsgo.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DriverService {
    @Autowired private DriverRepository driverRepository;

    public List<Driver> getActiveDriversSortedByName() {
        return driverRepository.findActiveDriversSortedByName(); // Is this method really needed?
    }

    public List<Driver> getDrivers(String driverId) {
        List<Driver> drivers;
        if (!driverId.isEmpty()) {
            drivers = driverRepository.findDriversByDriverId(Integer.parseInt(driverId));
        } else {
            drivers = driverRepository.findDriversByIsActive(true);
        }
        drivers.sort(Comparator.comparing(Driver::getLastName).thenComparing(Driver::getFirstName));
        return drivers;
    }

    public Driver getDriver(String driverId) {
        return driverRepository.findDriverByDriverId(Integer.parseInt(driverId));
    }
    public Driver getDriver(Integer driverId) {
        return driverRepository.findDriverByDriverId(driverId);
    }
    public void updateDriver(Driver driver) {
        driver.updateStatus();
        driver.updateSafetyScore();
        driverRepository.save(driver);
    }
    public void setDriverStatus(Integer driverId, String status) {
        Driver driver = driverRepository.findDriverByDriverId(driverId);
        driver.setDriverStatus(status);
        updateDriver(driver);
    }

}
