package com.example.letsgo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Integer routeId;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String locationStart = "";
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String locationEnd = "";
    @Column(columnDefinition = "FLOAT DEFAULT 0") public float routeDistance = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT 0") public float routeDuration = 0f;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Inactive'") public String routeStatus = "Inactive";
    @ManyToMany(mappedBy = "requestedRoutes") public Set<User> requestingUsers;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String routeImageSource = "";
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());


}