package com.example.letsgo.repositories;

import com.example.letsgo.entities.TripRider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRiderRepository extends JpaRepository<TripRider, Integer> {
    TripRider findTripRiderByTripRiderId(Integer tripRiderId);
    TripRider findTripRiderByTripIdAndRiderId(Integer tripId, Integer riderId);
    List<TripRider> findTripRidersByTripId(Integer tripId);
    List<TripRider> findTripRidersByRiderId(Integer riderId);
    List<TripRider> findTripRidersByFullName(String fullName);
    void deleteAllByTripId(Integer tripId);
}
