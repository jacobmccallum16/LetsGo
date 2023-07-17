package com.example.letsgov1.repositories;

import com.example.letsgov1.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider,Integer> {
}
