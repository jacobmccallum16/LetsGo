package com.example.letsgov1.repositories;

import com.example.letsgov1.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiderRepository extends JpaRepository<Rider,Integer> {
    List<Rider> findRiderByRiderId (Integer id);
}
