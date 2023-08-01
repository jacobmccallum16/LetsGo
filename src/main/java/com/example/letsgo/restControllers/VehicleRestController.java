package com.example.letsgo.restControllers;

import com.example.letsgo.entities.Vehicle;
import com.example.letsgo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle/")
public class VehicleRestController {
    @Autowired private VehicleService vehicleService;

    @GetMapping("/getAllVehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
    @GetMapping("/getAllPrimaryVehicles")
    public List<Vehicle> getAllPrimaryVehicles() {
        return vehicleService.getAllPrimaryVehicles();
    }
    @GetMapping("/getVehiclesByDriverId/{driverId}")
    public List<Vehicle> getAllVehiclesByDriverId(@PathVariable Integer driverId) {
        return vehicleService.getVehiclesByDriverId(driverId);
    }
    @GetMapping("/getPrimaryVehicleByDriverId/{driverId}")
    public Vehicle getPrimaryVehicleByDriverId(@PathVariable Integer driverId) {
        return vehicleService.getPrimaryVehicleByDriverId(driverId);
    }
    @GetMapping("/getVehicleById/{vehicleId}")
    public Vehicle getVehicleById(@PathVariable Integer vehicleId) {
        return vehicleService.getVehicleByVehicleId(vehicleId);
    }
    @GetMapping("/getVehicleByTripId/{tripId}")
    public Vehicle getVehicleByTripId(@PathVariable Integer tripId) {
        return vehicleService.getVehicleByTripId(tripId);
    }
    @PostMapping("/createVehicle/{driverId}")
    public Vehicle createVehicle(@PathVariable Integer driverId, @RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(driverId, vehicle);
    }
    @PutMapping("/updateVehicle/{driverId}")
    public Vehicle updateVehicle(@PathVariable Integer driverId, @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(driverId, vehicle);
    }
    @DeleteMapping("/deleteVehicle/{vehicleId}")
    public void deleteVehicle(@PathVariable Integer vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
    }

    @PutMapping("/setPrimaryVehicle/{vehicleId}")
    public void setPrimaryVehicle(@PathVariable Integer vehicleId) { vehicleService.setPrimaryVehicle(vehicleId);}
    @PutMapping("/unsetPrimaryVehicle/{vehicleId}")
    public void unsetPrimaryVehicle(@PathVariable Integer vehicleId) { vehicleService.unsetPrimaryVehicle(vehicleId);}

}
