package com.example.letsgo.restControllers;

import com.example.letsgo.entities.DriverTripTransaction;
import com.example.letsgo.entities.RiderTripTransaction;
import com.example.letsgo.entities.Trip;
import com.example.letsgo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips/")
public class TripRestController {

    @Autowired private TripService tripService;

    @PutMapping("/{tripId}/tripCalculations")
    public void tripCalculations(@PathVariable Integer tripId) {
        tripService.tripCalculations(tripId);
    }

    @GetMapping("/{tripId}/tripDetails/trip")
    public Trip getTripDetails(@PathVariable Integer tripId) {
        return tripService.getTripByTripId(tripId);
    }
    @GetMapping("/{tripId}/tripDetails/driver")
    public List<DriverTripTransaction> getTripDetailsDrivers(@PathVariable Integer tripId) {
        return tripService.getDriverTripTransactionByTripId(tripId);
    }
    @GetMapping("/{tripId}/tripDetails/riders")
    public List<RiderTripTransaction> getTripDetailsRiders(@PathVariable Integer tripId) {
        return tripService.getRiderTripTransactionsByTripId(tripId);
    }
}

