package com.example.letsgo.restControllers;

import com.example.letsgo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trips/")
public class TripRestController {

    @Autowired
    private TripService tripService;

    @PutMapping("/{tripId}/tripCalculations")
    public void tripCalculations(@PathVariable Integer tripId) {
        tripService.tripCalculations(tripId);
    }
}

