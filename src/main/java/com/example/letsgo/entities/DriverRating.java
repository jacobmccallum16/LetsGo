package com.example.letsgo.entities;

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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Integer driverRatingId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "trip_id") public Trip trip;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "rated_driver_id") public Driver ratedDriver;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "rated_by_user_id") public User ratedByUser;
    @Column(columnDefinition = "INTEGER DEFAULT 1") public Integer driverSafetyScore = 1; // 1 to 5
    @Column(columnDefinition = "INTEGER DEFAULT 0") public Integer driverSafetyRating = 0; // 0 to 2
    @Column(columnDefinition = "INTEGER DEFAULT 0") public Integer driverResponsibilityRating = 0; // 0 to 2
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String comments = "";
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
}