package com.example.letsgo.restControllers;

import com.example.letsgo.entities.DriverTripTransaction;
import com.example.letsgo.service.TripTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trip-transactions/")
public class TripTransactionRestController {
    @Autowired private TripTransactionService tripTransactionService;

    @GetMapping("/{tripId}/getDriverTripTransaction")
    public DriverTripTransaction getDriverTripTransaction(@PathVariable Integer tripId) {
        return tripTransactionService.getDriverTripTransactionByTripId(tripId);
    }
}
