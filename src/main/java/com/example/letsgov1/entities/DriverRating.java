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
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "trip_id") Trip trip;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "rated_driver_id") Driver ratedDriver;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "rated_by_user_id") User ratedByUser;
    @Column(columnDefinition = "INTEGER DEFAULT 1") Integer driverSafetyScore = 1; // 1 to 5
    @Column(columnDefinition = "INTEGER DEFAULT 0") Integer driverSafetyRating = 0; // 0 to 2
    @Column(columnDefinition = "INTEGER DEFAULT 0") Integer driverResponsibilityRating = 0; // 0 to 2
    String comments;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;
}