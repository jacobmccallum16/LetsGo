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
public class RiderRating {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer riderRatingId;
    // Trip trip;
    // Rider ratedRider;
    // User ratingUser;
    Boolean ratedByDriver = false;
    Integer riderSafetyScore = 1; // 1 to 5
    Integer riderSafetyRating = 0; // 0 to 2
    Integer riderResponsibilityRating = 0; // 0 to 2
    String comments;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;
}