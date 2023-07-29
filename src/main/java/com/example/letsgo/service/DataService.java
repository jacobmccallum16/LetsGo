package com.example.letsgo.service;

import com.example.letsgo.entities.Driver;
import com.example.letsgo.entities.Trip;
import com.example.letsgo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
    @Autowired private UserRepository userRepository;
    @Autowired private DriverRepository driverRepository;
    @Autowired private RiderRepository riderRepository;
    @Autowired private RouteRepository routeRepository;
    @Autowired private TripRepository tripRepository;

    public List<Trip> getTripsByDriver(String id) {
        Integer driverId = Integer.parseInt(id);
        Driver driver = driverRepository.findDriverByDriverId(driverId);
        return tripRepository.findTripsByDriver(driver);
    }
}
