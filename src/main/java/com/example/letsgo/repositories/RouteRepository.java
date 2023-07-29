package com.example.letsgo.repositories;

import com.example.letsgo.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
    List<Route> findRoutesByRouteId(Integer keyId);
    Route findRouteByRouteId(Integer keyId);
}
