package com.example.letsgo.service;

import com.example.letsgo.entities.Rider;
import com.example.letsgo.entities.Trip;
import com.example.letsgo.entities.TripRider;
import com.example.letsgo.repositories.DriverRepository;
import com.example.letsgo.repositories.RiderRepository;
import com.example.letsgo.repositories.TripRepository;
import com.example.letsgo.repositories.TripRiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripRiderService {
    @Autowired private TripRiderRepository tripRiderRepository;
    @Autowired private TripRepository tripRepository;
    @Autowired private DriverRepository driverRepository;
    @Autowired private RiderRepository riderRepository;

    public TripRider getTripRiderById(String id) {
        return tripRiderRepository.findTripRiderByTripRiderId(Integer.parseInt(id));
    }
    public TripRider getTripRiderByTripIdAndRiderId(String tripId, String riderId) {
        return tripRiderRepository.findTripRiderByTripIdAndRiderId(Integer.parseInt(tripId), Integer.parseInt(riderId));
    }
    public List<TripRider> getTripRidersByTripId(String tripId) {
        return tripRiderRepository.findTripRidersByTripId(Integer.parseInt(tripId));
    }
    public List<TripRider> getTripRidersByRiderId(String riderId) {
        return tripRiderRepository.findTripRidersByRiderId(Integer.parseInt(riderId));
    }
    public List<TripRider> getTripRidersByFullName(String fullName) {
        return tripRiderRepository.findTripRidersByFullName(fullName);
    }
    public List<Rider> getPotentialRidersByTripSortedByName(String tripId) {
        List<TripRider> tripRiders = tripRiderRepository.findTripRidersByTripId(Integer.parseInt(tripId));
        List<Rider> riders = riderRepository.findActiveRidersSortedByName();
        Trip trip = tripRepository.findTripByTripId(Integer.parseInt(tripId));
        boolean checkDriverRiderId = false;
        if (trip.getDriver() != null) {
            checkDriverRiderId = true;
        }
        boolean busy = false;
        for (int i = riders.size() - 1; i >= 0; i--) {
            int riderId = riders.get(i).getRiderId();
            busy = false; // resetting this for every potential rider to be checked
            for (int j = 0; j < tripRiders.size(); j++) {
                int tripRiderRiderId = tripRiders.get(j).getRiderId();
                if (tripRiderRiderId == riderId) {
                    busy = true; // if potential rider is already taking this trip
                }
            }
            if (checkDriverRiderId) {
                if (riderId == trip.getDriverRiderId()) {
                    busy = true; // if potential rider is the driver of this trip
                }
            }
            if (busy) {
                riders.remove(i); // remove rider if they're busy
            }
        }
        return riders;
    }
    public void updateTripRiders(Integer tripId, List<TripRider> updatedRiders) {
        tripRiderRepository.deleteAllByTripId(tripId);
        tripRiderRepository.saveAll(updatedRiders);
    }
    public TripRider addTripRider(TripRider tripRider) {
        return tripRiderRepository.save(tripRider);
    }
    public void deleteTripRider(Integer tripRiderId) {
        tripRiderRepository.deleteById(tripRiderId);
    }
}