package com.example.letsgo.repositories;

import com.example.letsgo.entities.Driver;
import com.example.letsgo.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    Vehicle findVehicleByVehicleId(Integer vehicleId);
    List<Vehicle> findVehiclesByDriver(Driver driver);
    List<Vehicle> findVehiclesByPrimaryVehicleIsTrue();
    Vehicle findVehicleByDriverAndPrimaryVehicleIsTrue(Driver driver);
}
