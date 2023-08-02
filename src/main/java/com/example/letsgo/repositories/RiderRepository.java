package com.example.letsgo.repositories;

import com.example.letsgo.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiderRepository extends JpaRepository<Rider,Integer> {
    List<Rider> findRidersByRiderId(Integer riderId);
    Rider findRiderByRiderId(Integer riderId);
    @Query("SELECT r FROM Rider r JOIN r.user u WHERE r.riderStatus = 'Active' ORDER BY u.lastName, u.firstName")
    List<Rider> findActiveRidersSortedByName();
}
