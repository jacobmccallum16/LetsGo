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
public class DriverRating {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer driverRatingId;
    // Trip trip;
    // Driver ratedDriver;
    // User ratingUser;
    Integer driverSafetyScore = 1; // 1 to 5
    Integer driverSafetyRating = 0; // 0 to 2
    Integer driverResponsibilityRating = 0; // 0 to 2
    String comments;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") Float driverResponsibilityRating = 0f;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;
}