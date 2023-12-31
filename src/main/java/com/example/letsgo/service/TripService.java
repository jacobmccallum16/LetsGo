package com.example.letsgo.service;

import com.example.letsgo.entities.*;
import com.example.letsgo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired private TripRepository tripRepository;
    @Autowired private RouteRepository routeRepository;
    @Autowired private DriverRepository driverRepository;
    @Autowired private VehicleRepository vehicleRepository;
    @Autowired private RiderRepository riderRepository;
    @Autowired private TripRiderRepository tripRiderRepository;
    @Autowired DriverTripTransactionRepository driverTripTransactionRepository;
    @Autowired RiderTripTransactionRepository riderTripTransactionRepository;

    public List<Trip> getTripsByRouteId(Integer routeId) {
        Route route = routeRepository.findRouteByRouteId(routeId);
        return tripRepository.findTripsByRoute(route);
    }
    public List<Trip> getTrips(String routeId, String driverId, String tripId) {
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
    public String getTripsTitle(String routeId, String driverId, String tripId) {
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
    public Trip newTrip(Integer routeId) {
        Route route = routeRepository.findRouteByRouteId(routeId);
        return new Trip(route);
    }
    public void createTrip(Trip trip) {
        trip.setTripImageSource(trip.getRoute().getRouteImageSource());
        trip.setTripDistanceEstimated(trip.getRoute().getRouteDistance());
        trip.setTripDistanceActual(trip.getRoute().getRouteDistance());
        trip.setTripDurationEstimated(trip.getRoute().getRouteDistance());
        trip.setTripDurationActual(trip.getRoute().getRouteDistance());
        trip.calculateArrivalTime();
        tripRepository.save(trip);
    }

    public void tripCalculations(Integer tripId) {
        Trip trip = tripRepository.findTripByTripId(tripId);
        updateTrip(trip);
    }
    public void processEditTripForm(Trip trip) {
        if (trip.getDriver().getDriverId() == -1) {
            trip.setDriver(null);
        }
        updateTrip(trip);
        createDriverTripTransaction(trip);
    }
    public void saveTrip(Trip trip) {
        tripRepository.save(trip);
    }
    public void updateTrip(Trip trip) {
        Route route = routeRepository.findRouteByRouteId(trip.getRoute().getRouteId());
        Integer riderCount = tripRiderRepository.countByTripId(trip.getTripId());
        trip.setPassengers(riderCount);
        trip.setTripImageSource(route.getRouteImageSource());
        trip.setTripDistanceEstimated(route.getRouteDistance());
        trip.setTripDistanceActual(route.getRouteDistance());
        trip.setTripDurationEstimated(route.getRouteDuration());
        trip.setTripDurationActual(route.getRouteDuration());
        trip.setArrivalTime(trip.getDepartureTime().plusMinutes(trip.getTripDurationEstimated().longValue()));
        if (trip.getDriver() != null) {
            Vehicle vehicle = vehicleRepository.findVehicleByDriverAndPrimaryVehicleIsTrue(trip.getDriver());
            trip.setVehicle(vehicle);
            trip.setPassengersMax(vehicle.getSeatsAvailable());
        } else {
            trip.setVehicle(null);
            trip.setPassengersMax(2); // Vehicles that can't have at least two passengers wouldn't be approved anyway.
        }
        trip.setSeatsLeft(trip.getPassengersMax() - trip.getPassengers());
        tripRepository.save(trip);
    }

    public List<Driver> getPotentialDriversSortedByName(String tripId) {
        Trip trip = tripRepository.findTripByTripId(Integer.parseInt(tripId));
        List<Driver> drivers = driverRepository.findActiveDriversSortedByName();
        List<TripRider> tripRiders = tripRiderRepository.findTripRidersByTripId(Integer.parseInt(tripId));
        Rider rider;
        int index;
        for (int i = 0; i < tripRiders.size(); i++) {
            rider = riderRepository.findRiderByRiderId(tripRiders.get(i).getRiderId());
            if (driverRepository.existsByDriverId(rider.getDriverId())) {
                drivers.remove(rider.getDriver());
            }
        }
        return drivers;
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
    public void deleteRiderTripTransaction2(Integer tripRiderId) {
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


    // trip details page
    public Driver getDriverOfTrip(Integer tripId) {
        Trip trip = tripRepository.findTripByTripId(tripId);
        Driver driver = null;
        if (trip.getDriver() != null) {
            driver = driverRepository.findDriverByDriverId(trip.getDriver().getDriverId());
        }
        return driver;
    }
    public List<TripRider> getRidersOfTrip(Integer tripId) {
        Trip trip = tripRepository.findTripByTripId(tripId);
        return tripRiderRepository.findTripRidersByTripId(tripId);
    }
    public Trip getTripByTripId(Integer tripId) {
        return tripRepository.findTripByTripId(tripId);
    }
    public List<DriverTripTransaction> getDriverTripTransactionByTripId(Integer tripId) {
        Trip trip = tripRepository.findTripByTripId(tripId);
        return driverTripTransactionRepository.findAllByTrip(trip);
    }
    public List<RiderTripTransaction> getRiderTripTransactionsByTripId(Integer tripId) {
        Trip trip = tripRepository.findTripByTripId(tripId);
        return riderTripTransactionRepository.findAllByTrip(trip);
    }



}
