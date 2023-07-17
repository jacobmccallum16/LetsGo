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
    @OneToOne(optional = false, mappedBy = "driver") User user;
    Boolean isActive = false;
    String driverStatus = "inactive";
    Integer tripsDriver = 0;
    Integer timesRated = 0;
    Float driverSafetyScore = 0f;
    Float driverSafetyRating = 0f;
    Float driverResponsibilityRating = 0f;
    Timestamp createdAt;
    Timestamp updatedAt;
    public Driver(User user) {
        this.user = user;
        isActive = false;
        driverStatus = "inactive";
        createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
