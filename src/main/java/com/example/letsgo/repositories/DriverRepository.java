package com.example.letsgo.repositories;

import com.example.letsgo.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {
    List<Driver> findDriversByDriverId(Integer id);
    Driver findDriverByDriverId(Integer id);
    @Query("SELECT d FROM Driver d JOIN d.user u WHERE d.driverStatus = 'Active' ORDER BY u.lastName, u.firstName")
    List<Driver> findActiveDriversSortedByName();
    @Query("SELECT d FROM Driver d JOIN d.user u WHERE d.isActive = true ORDER BY u.lastName, u.firstName")
    List<Driver> findIsActiveDriversSortedByName();
    List<Driver> findDriversByIsActive(Boolean bool);
    List<Driver> findDriversByDriverStatus(String driverStatus);
    List<Driver> findDriversByDriverStatusOrDriverStatus(String driverStatus1, String driverStatus2);
    Boolean existsByDriverId(Integer driverId);
}
