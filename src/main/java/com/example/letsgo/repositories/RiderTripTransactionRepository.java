package com.example.letsgo.repositories;

import com.example.letsgo.entities.RiderTripTransaction;
import com.example.letsgo.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiderTripTransactionRepository extends JpaRepository<RiderTripTransaction, Integer> {
    List<RiderTripTransaction> findAllByTrip(Trip trip);
    RiderTripTransaction findByRiderTripTransactionId(Integer riderTripTransactionId);
}
