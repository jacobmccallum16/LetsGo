package com.example.letsgo.repositories;

import com.example.letsgo.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiderRepository extends JpaRepository<Rider,Integer> {
    List<Rider> findRiderByRiderId (Integer id);
}
