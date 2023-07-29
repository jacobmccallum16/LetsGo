package com.example.letsgo.web;

import com.example.letsgo.entities.Trip;
import com.example.letsgo.repositories.DriverRepository;
import com.example.letsgo.repositories.TripRepository;
import com.example.letsgo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminRestController {
    @Autowired
    private DataService dataService;
    private TripRepository tripRepository;
    private DriverRepository driverRepository;

    @GetMapping("/api/getTripsByDriver/{id}")
    public ResponseEntity<List<Trip>> getTripsByDriver(@PathVariable String id) {
        List<Trip> trips = dataService.getTripsByDriver(id);
        if (trips != null) {
            return new ResponseEntity<>(trips, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
