package com.example.letsgo.service;

import com.example.letsgo.entities.Driver;
import com.example.letsgo.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getActiveDriversSortedByName() {
        return driverRepository.findActiveDriversSortedByName(); // Is this method really needed?
    }
}
