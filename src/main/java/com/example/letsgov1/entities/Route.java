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
public class Route {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer routeId;
    @OneToOne(mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.LAZY) Trip trip;
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.LAZY) List<TripTransaction> tripTransactions;
    String locationStart = "";
    String locationEnd = "";
    @Column(columnDefinition = "FLOAT DEFAULT 0") float routeDistance = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT 0") float routeDuration = 0f;
    String routeStatus = "inactive";
    // Integer[] requestedBy;
    String routeImageSource;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;
}