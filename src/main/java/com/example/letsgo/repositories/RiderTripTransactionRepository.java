package com.example.letsgo.repositories;

import com.example.letsgo.entities.RiderTripTransaction;
import com.example.letsgo.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiderTripTransactionRepository extends JpaRepository<RiderTripTransaction, Integer> {
    List<RiderTripTransaction> findAllByTrip(Trip trip);
    List<RiderTripTransaction> findAllByRiderId(Integer riderId);
    RiderTripTransaction findByRiderTripTransactionId(Integer riderTripTransactionId);
    RiderTripTransaction findByTripAndRiderId(Trip trip, Integer riderId);
    Boolean existsByTripAndRiderId(Trip trip, Integer riderId);
    void deleteByTripAndRiderId(Trip trip, Integer riderId);
}
