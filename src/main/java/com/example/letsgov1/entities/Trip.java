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
public class Trip {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer tripId;
    // Route route
    // Vehicle vehicle
    // Driver driver
    Integer seatsAvailanle = 0;
    Integer seatsUsed = 0;
    // Integer[] ridersIds;
    String tripStatus = "planned";
    // Integer[] requestedBy;
    // Date date
    // DateTime departureTime;
    // DateTime arrivalTime;
    String tripImageSource;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") Float driverResponsibilityRating = 0f;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;
}