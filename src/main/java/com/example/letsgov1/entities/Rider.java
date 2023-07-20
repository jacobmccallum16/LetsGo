package com.example.letsgov1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Rider {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer riderId;
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") User user;
    @OneToMany(mappedBy = "ratedRider", cascade = CascadeType.ALL, fetch = FetchType.LAZY) List<RiderRating> riderRatings;
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE") Boolean isActive;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'inactive'") String riderStatus;
    @Column(columnDefinition = "INTEGER DEFAULT '0'") Integer tripsTaken = 0;
    @Column(columnDefinition = "INTEGER DEFAULT '0'") Integer timesRated = 0;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") Float riderSafetyScore = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") Float riderSafetyRating = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") Float riderResponsibilityRating = 0f;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;
    public Rider(User user) {
        this.user = user;
        isActive = false;
        riderStatus = "inactive";
        createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
    public Boolean toggleIsActive() {
        if (riderStatus != "banned") {
            if (!isActive) {
                isActive = true;
                riderStatus = "active";
            } else {
                isActive = false;
                riderStatus = "inactive";
            }
        } else {
            isActive = false;
        }
        updatedAt = new Timestamp(System.currentTimeMillis());
        return isActive;
    }
}
