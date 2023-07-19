package com.example.letsgov1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer routeId;
    // Trips trips
    String locationStart = "";
    String locationEnd = "";
    float routeDistance = 0f;
    float routeDuration = 0f;
    String routeStatus = "inactive";
    // Integer[] requestedBy;
    String routeImageSource;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") Float driverResponsibilityRating = 0f;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;
}