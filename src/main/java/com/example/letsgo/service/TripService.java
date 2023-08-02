package com.example.letsgo.service;

import com.example.letsgo.entities.Driver;
import com.example.letsgo.entities.Route;
import com.example.letsgo.entities.Trip;
import com.example.letsgo.repositories.DriverRepository;
import com.example.letsgo.repositories.RouteRepository;
import com.example.letsgo.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired private TripRepository tripRepository;
    @Autowired private RouteRepository routeRepository;
    @Autowired private DriverRepository driverRepository;

    public List<Trip> getTripsByRouteId(Integer routeId) {
        Route route = routeRepository.findRouteByRouteId(routeId);
        return tripRepository.findTripsByRoute(route);
    }
    public List<Trip> adminTrips(String routeId, String driverId, String tripId) {
        List<Trip> trips;
        if (!routeId.isEmpty()) {
            Route route = routeRepository.findRouteByRouteId(Integer.parseInt(routeId));
            trips = tripRepository.findTripsByRoute(route);
        } else if (!driverId.isEmpty()) {
            Driver driver = driverRepository.findDriverByDriverId(Integer.parseInt(driverId));
            trips = tripRepository.findTripsByDriver(driver);
        } else if (!tripId.isEmpty()) {
            trips = tripRepository.findTripsByTripId(Integer.parseInt(tripId));
        } else {
            trips = tripRepository.findAll();
        }
        Trip.sortByDateAndTime(trips);
        return trips;
    }
    public String adminTripsTitle(String routeId, String driverId, String tripId) {
        String title = "Trips";
        if (!routeId.isEmpty()) {
            title = "Trips on route " + routeId;
        } else if (!driverId.isEmpty()) {
            title = "Trips driven by " + driverRepository.findDriverByDriverId(Integer.parseInt(driverId)).getFullName();
        } else if (!tripId.isEmpty()) {
            title = "Trip #" + tripRepository.findTripByTripId(Integer.parseInt(tripId)).getTripId();
        } else {
            title = "All trips";
        }
        return title;
    }

    public void tripCalculations(Integer tripId) {
        Trip trip = tripRepository.findTripByTripId(tripId);
        Route route = routeRepository.findRouteByRouteId(trip.getRoute().getRouteId());
        trip.setTripDistanceEstimated(route.getRouteDistance());
        trip.setTripDistanceActual(route.getRouteDistance());
        trip.setTripDurationEstimated(route.getRouteDuration());
        trip.setTripDurationActual(route.getRouteDuration());
        tripRepository.save(trip);
    }
}
