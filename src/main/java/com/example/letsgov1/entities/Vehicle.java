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
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer vehicleId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "driver_id") Driver driver;
    String vehicleStatus = "inactive";
    String name;
    String color;
    String type;
    @Column(columnDefinition = "INTEGER DEFAULT 0") Integer seatsTotal = 0;
    @Column(columnDefinition = "INTEGER DEFAULT 0") Integer seatsAvailable = 0;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;
}