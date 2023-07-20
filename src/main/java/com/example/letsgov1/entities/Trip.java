package com.example.letsgov1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Integer tripId;
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "route_id") public Route route;
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "driver_id") public Driver driver;
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "vehicle_id") public Vehicle vehicle;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<TripTransaction> tripTransaction;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<RiderRating> riderRatings;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<DriverRating> driverRatings;
    @Column(columnDefinition = "INTEGER DEFAULT 0") public Integer seatsAvailable = 0;
    @Column(columnDefinition = "INTEGER DEFAULT 0") public Integer seatsUsed = 0;
    // Integer[] ridersIds;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'planned'") public String tripStatus = "planned";
    // Integer[] requestedBy;
    @Column(columnDefinition = "DATE") public LocalDate date;
    @Column(columnDefinition = "TIME") public LocalTime departureTime;
    @Column(columnDefinition = "TIME") public LocalTime arrivalTime;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String tripImageSource = "";
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
}