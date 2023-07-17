package com.example.letsgov1.repositories;

import com.example.letsgov1.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
}
