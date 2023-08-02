package com.example.letsgo.service;

import com.example.letsgo.entities.*;
import com.example.letsgo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripTransactionService {
    @Autowired TripRepository tripRepository;
    @Autowired TripRiderRepository tripRiderRepository;
    @Autowired RiderRepository riderRepository;
    @Autowired DriverRepository driverRepository;
    @Autowired DriverTripTransactionRepository driverTripTransactionRepository;
    @Autowired RiderTripTransactionRepository riderTripTransactionRepository;
    final TripService tripService;

    public TripTransactionService(TripService tripService) {
        this.tripService = tripService;
    }

    public DriverTripTransaction getDriverTripTransactionByTripId(Integer tripId) {
        Trip trip = tripRepository.findTripByTripId(tripId);
        return driverTripTransactionRepository.findByTrip(trip);
    }

    public void createDriverTripTransaction(Trip trip) {
        Driver driver = trip.getDriver();
        DriverTripTransaction driverTripTransaction;
        if (driverTripTransactionRepository.existsByTrip(trip)) {
            driverTripTransaction = driverTripTransactionRepository.findByTrip(trip);
        } else {
            driverTripTransaction = new DriverTripTransaction(trip, driver);
        }
        driverTripTransaction.preTripCalculations(driver);
        save(driverTripTransaction);
    }
    public void createRiderTripTransaction(TripRider tripRider) {
        Trip trip = tripRepository.findTripByTripId(tripRider.getTripId());
        Rider rider = riderRepository.findRiderByRiderId(tripRider.getRiderId());
        RiderTripTransaction riderTripTransaction;
        if (riderTripTransactionRepository.existsByTripAndRiderId(trip, rider.getRiderId())) {
            riderTripTransaction = riderTripTransactionRepository.findByTripAndRiderId(trip, rider.getRiderId());
        } else {
            riderTripTransaction = new RiderTripTransaction(trip, rider);
        }
        riderTripTransaction.preTripCalculations(rider);
        save(riderTripTransaction);
    }
    public void deleteRiderTripTransaction(Integer tripRiderId) {
        TripRider tripRider = tripRiderRepository.findTripRiderByTripRiderId(tripRiderId);
        Trip trip = tripRepository.findTripByTripId(tripRider.getTripId());
        Rider rider = riderRepository.findRiderByRiderId(tripRider.getRiderId());
        RiderTripTransaction riderTripTransaction = riderTripTransactionRepository.findByTripAndRiderId(trip, rider.getRiderId());
        riderTripTransactionRepository.delete(riderTripTransaction);
    }

    public void save(DriverTripTransaction driverTripTransaction) {
        driverTripTransactionRepository.save(driverTripTransaction);
    }
    public void save(RiderTripTransaction riderTripTransaction) {
        riderTripTransactionRepository.save(riderTripTransaction);
    }
    public void saveAll(List<RiderTripTransaction> riderTripTransactions) {
        riderTripTransactionRepository.saveAll(riderTripTransactions);
    }
    public void saveAll(DriverTripTransaction driverTripTransaction, List<RiderTripTransaction> riderTripTransactions) {
        driverTripTransactionRepository.save(driverTripTransaction);
        riderTripTransactionRepository.saveAll(riderTripTransactions);
    }
}
