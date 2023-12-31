package com.example.letsgo.restControllers;

import com.example.letsgo.entities.Rider;
import com.example.letsgo.entities.TripRider;
import com.example.letsgo.service.RiderService;
import com.example.letsgo.service.TripRiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip-rider/")
public class TripRiderRestController {
    private final TripRiderService tripRiderService;
    @Autowired private RiderService riderService;

    @Autowired
    public TripRiderRestController(TripRiderService tripRiderService) {
        this.tripRiderService = tripRiderService;
    }

    @GetMapping("/{tripId}/getPotentialRiders")
    public List<Rider> getPotentialRidersByTrip(@PathVariable Integer tripId) {
        return tripRiderService.getPotentialRidersByTripSortedByName(String.valueOf(tripId));
    }
    @GetMapping("/{tripId}/riders")
    public List<TripRider> getTripRiders(@PathVariable Integer tripId) {
        return tripRiderService.getTripRidersByTripId(String.valueOf(tripId));
    }
    @PutMapping("/{tripId}/riders")
    public void updateTripRiders(@PathVariable Integer tripId, @RequestBody List<TripRider> updatedRiders) {
        tripRiderService.updateTripRiders(tripId, updatedRiders);
    }
    @PostMapping("/{tripId}/addRider")
    public TripRider addTripRider(@PathVariable Integer tripId, @RequestBody TripRider tripRider) {
        tripRider.setTripId(tripId);
        return tripRiderService.addTripRider(tripRider);
    }
    @DeleteMapping("/removeById/{tripRiderId}")
    public void removeTripRider(@PathVariable Integer tripRiderId) {
        tripRiderService.deleteTripRider(tripRiderId);
    }
    @GetMapping("/removeById/{tripRiderId}")
    public ResponseEntity<Void> removeTripRiderGet(@PathVariable Integer tripRiderId) {
        tripRiderService.deleteTripRider(tripRiderId);
        return ResponseEntity.noContent().build();
    }
}
