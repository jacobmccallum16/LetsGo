package com.example.letsgov1.repositories;

import com.example.letsgov1.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Integer> {
    List<Route> findRoutesByRouteId(Integer keyId);
    Route findRouteByRouteId(Integer keyId);
}
