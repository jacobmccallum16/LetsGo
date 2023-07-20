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
public class Trip {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer tripId;
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "route_id") Route route;
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "driver_id") Driver driver;
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "vehicle_id") Vehicle vehicle;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY) List<TripTransaction> tripTransaction;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY) List<RiderRating> riderRatings;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY) List<DriverRating> driverRatings;
    @Column(columnDefinition = "INTEGER DEFAULT 0") Integer seatsAvailable = 0;
    @Column(columnDefinition = "INTEGER DEFAULT 0") Integer seatsUsed = 0;
    // Integer[] ridersIds;
    String tripStatus = "planned";
    // Integer[] requestedBy;
    // Date date
    // DateTime departureTime;
    // DateTime arrivalTime;
    String tripImageSource;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;
}