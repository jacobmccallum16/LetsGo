package com.example.letsgo.service;

import com.example.letsgo.entities.Route;
import com.example.letsgo.entities.Trip;
import com.example.letsgo.repositories.RouteRepository;
import com.example.letsgo.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;
    private RouteRepository routeRepository;

    public List<Trip> getTripsByRouteId(Integer routeId) {
        Route route = routeRepository.findRouteByRouteId(routeId);
        return tripRepository.findTripsByRoute(route);
    }
}
