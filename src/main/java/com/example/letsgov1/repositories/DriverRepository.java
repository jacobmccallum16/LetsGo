package com.example.letsgov1.repositories;

import com.example.letsgov1.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
    List<Driver> findDriverByDriverId (Integer id);
}
