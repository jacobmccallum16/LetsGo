package com.example.letsgo.repositories;

import com.example.letsgo.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {
    List<Trip> findTripsByTripId(Integer id);
    Trip findTripByTripId(Integer id);
}
