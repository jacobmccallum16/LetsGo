package com.example.letsgo.service;

import com.example.letsgo.entities.Driver;
import com.example.letsgo.entities.Trip;
import com.example.letsgo.entities.Vehicle;
import com.example.letsgo.repositories.DriverRepository;
import com.example.letsgo.repositories.TripRepository;
import com.example.letsgo.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired private VehicleRepository vehicleRepository;
    @Autowired private TripRepository tripRepository;
    @Autowired private DriverRepository driverRepository;

    public void deleteVehicle(Vehicle vehicle) { vehicleRepository.delete(vehicle);}

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
    public List<Vehicle> getVehiclesByDriverId(Integer driverId) {
        Driver driver = driverRepository.findDriverByDriverId(driverId);
        return vehicleRepository.findVehiclesByDriver(driver);
    }
    public List<Vehicle> getAllPrimaryVehicles() {
        return vehicleRepository.findVehiclesByPrimaryVehicleIsTrue();
    }
    public Vehicle getPrimaryVehicleByDriverId(Integer driverId) {
        Driver driver = driverRepository.findDriverByDriverId(driverId);
        return vehicleRepository.findVehicleByDriverAndPrimaryVehicleIsTrue(driver);
    }
    public Vehicle getVehicleByVehicleId(Integer vehicleId) {
        return vehicleRepository.findVehicleByVehicleId(vehicleId);
    }
    public Vehicle getVehicleByTripId(Integer tripID) {
        Trip trip = tripRepository.findTripByTripId(tripID);
        return vehicleRepository.findVehicleByVehicleId(trip.getVehicle().getVehicleId());
    }

    public Vehicle createVehicle(Integer driverId, Vehicle vehicle) {
        Driver driver = driverRepository.findDriverByDriverId(driverId);
        vehicle.setDriver(driver);
        return vehicleRepository.save(vehicle);
    }
    public Vehicle updateVehicle(Integer driverId, Vehicle vehicle) {
        Driver driver = driverRepository.findDriverByDriverId(driverId);
        vehicle.setDriver(driver);
        return vehicleRepository.save(vehicle);
    }
    public void deleteVehicle(Integer vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }

    public void setPrimaryVehicle(Integer vehicleId) {
        Vehicle primaryVehicle = vehicleRepository.findVehicleByVehicleId(vehicleId);
        Driver driver = driverRepository.findDriverByDriverId(primaryVehicle.getDriverId());
        List<Vehicle> vehicles = vehicleRepository.findVehiclesByDriver(driver);
        vehicles.forEach((vehicle) -> {
            vehicle.setPrimaryVehicle(vehicle.equals(primaryVehicle));
            vehicleRepository.save(vehicle);
        });
    }
    public void unsetPrimaryVehicle(Integer vehicleId) {
        Vehicle vehicle = vehicleRepository.findVehicleByVehicleId(vehicleId);
        vehicle.setPrimaryVehicle(false);
        vehicleRepository.save(vehicle);
    }
}
