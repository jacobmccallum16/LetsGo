package com.example.letsgo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer vehicleId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "driver_id") @JsonIgnoreProperties({"hibernateLazyInitializer"}) private Driver driver;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Inactive'") private String vehicleStatus = "Inactive";
    @Column(columnDefinition = "BOOLEAN DEFAULT false") private Boolean primaryVehicle = false;
    @Column(columnDefinition = "INTEGER DEFAULT null") private Integer year;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT null") private String make = "";
    @Column(columnDefinition = "VARCHAR(255) DEFAULT null") private String model = "";
    @Column(columnDefinition = "VARCHAR(255) DEFAULT null") private String color = "";
    @Column(columnDefinition = "VARCHAR(255) DEFAULT '999999'") private String colorHexCode = "999999";
    @Column(columnDefinition = "INTEGER DEFAULT 0") private Integer seatsTotal = 0;
    @Column(columnDefinition = "INTEGER DEFAULT 0") private Integer seatsAvailable = 0;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") private Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

    public Integer getDriverId() { return getDriver().getDriverId(); }
    public String getDriverFullName() { return getDriver().getFullName(); }
}