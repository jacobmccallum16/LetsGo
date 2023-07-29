package com.example.letsgo.repositories;

import com.example.letsgo.entities.Driver;
import com.example.letsgo.entities.Route;
import com.example.letsgo.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
    List<Trip> findTripsByTripId(Integer id);
    Trip findTripByTripId(Integer id);
    List<Trip> findTripsByRoute(Route route);
    List<Trip> findTripsByDriver(Driver driver);
    Integer countTripsByDriver(Driver driver);
}
