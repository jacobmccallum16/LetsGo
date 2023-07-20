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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Integer vehicleId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "driver_id") public Driver driver;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'inactive'") public String vehicleStatus = "inactive";
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String name = "";
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String color = "";
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String type = "";
    @Column(columnDefinition = "INTEGER DEFAULT 0") public Integer seatsTotal = 0;
    @Column(columnDefinition = "INTEGER DEFAULT 0") public Integer seatsAvailable = 0;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
}