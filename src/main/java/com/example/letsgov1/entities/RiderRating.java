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
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "trip_id") Trip trip;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "rated_rider_id") Rider ratedRider;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "rated_by_user_id") User ratedByUser;
    @Column(columnDefinition = "BOOLEAN DEFAULT false") Boolean ratedByDriver = false;
    @Column(columnDefinition = "INTEGER DEFAULT 1") Integer riderSafetyScore = 1; // 1 to 5
    @Column(columnDefinition = "INTEGER DEFAULT 0") Integer riderSafetyRating = 0; // 0 to 2
    @Column(columnDefinition = "INTEGER DEFAULT 0") Integer riderResponsibilityRating = 0; // 0 to 2
    String comments;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;
}