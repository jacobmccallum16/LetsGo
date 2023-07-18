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
public class Driver {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer driverId;
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") User user;
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE") Boolean isActive = false;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'inactive'") String driverStatus = "inactive";
    @Column(columnDefinition = "INTEGER DEFAULT 0") Integer tripsDriven = 0;
    @Column(columnDefinition = "INTEGER DEFAULT '0'") Integer timesRated = 0;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") Float driverSafetyScore = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") Float driverSafetyRating = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") Float driverResponsibilityRating = 0f;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;
    public Driver(User user) {
        this.user = user;
        isActive = false;
        driverStatus = "inactive";
        createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
    public Boolean toggleIsActive() {
        if (driverStatus != "banned") {
            if (!isActive) {
                isActive = true;
                driverStatus = "active";
            } else {
                isActive = false;
                driverStatus = "inactive";
            }
        } else {
            isActive = false;
        }
        updatedAt = new Timestamp(System.currentTimeMillis());
        return isActive;
    }
}
