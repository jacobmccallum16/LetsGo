package com.example.letsgo.repositories;

import com.example.letsgo.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiderRepository extends JpaRepository<Rider,Integer> {
    List<Rider> findRiderByRiderId (Integer id);
}
