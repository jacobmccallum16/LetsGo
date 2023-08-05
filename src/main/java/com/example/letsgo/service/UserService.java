package com.example.letsgo.service;

import com.example.letsgo.entities.*;
import com.example.letsgo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;
    @Autowired private DriverRepository driverRepository;
    @Autowired private DriverTripTransactionRepository driverTripTransactionRepository;
    @Autowired private RiderRepository riderRepository;
    @Autowired private RiderTripTransactionRepository riderTripTransactionRepository;

    public User getUser(Integer userId) {
        return userRepository.findUserByUserId(userId);
    }
    public Driver getDriver(Integer driverId) {
        return driverRepository.findDriverByDriverId(driverId);
    }
    public List<DriverTripTransaction> getDriverTripTransactions(Integer driverId) {
        return driverTripTransactionRepository.findAllByDriverId(driverId);
    }
    public Rider getRider(Integer riderId) {
        return riderRepository.findRiderByRiderId(riderId);
    }
    public List<RiderTripTransaction> getRiderTripTransactions(Integer riderId) {
        return riderTripTransactionRepository.findAllByRiderId(riderId);
    }


}
