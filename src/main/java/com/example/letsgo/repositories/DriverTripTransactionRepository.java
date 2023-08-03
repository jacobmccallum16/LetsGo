package com.example.letsgo.repositories;

import com.example.letsgo.entities.DriverTripTransaction;
import com.example.letsgo.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverTripTransactionRepository extends JpaRepository<DriverTripTransaction, Integer> {
    List<DriverTripTransaction> findAllByTrip(Trip trip);
    DriverTripTransaction findByDriverTripTransactionId(Integer driverTripTransactionId);
    DriverTripTransaction findByTrip(Trip trip);
    Boolean existsByTrip(Trip trip);
    void deleteByTrip(Trip trip);
}