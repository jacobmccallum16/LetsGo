package com.example.letsgo.repositories;

import com.example.letsgo.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
    List<Driver> findDriverByDriverId (Integer id);
}