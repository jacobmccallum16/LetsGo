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
public class Driver {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Integer driverId;
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") public User user;
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<Vehicle> vehicle;
    @OneToMany(mappedBy = "ratedDriver", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<DriverRating> driverRatings;
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE") public Boolean isActive = false;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'inactive'") public String driverStatus = "inactive";
    @Column(columnDefinition = "INTEGER DEFAULT 0") public Integer tripsDriven = 0;
    @Column(columnDefinition = "INTEGER DEFAULT '0'") public Integer timesRated = 0;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") public Float driverSafetyScore = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") public Float driverSafetyRating = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") public Float driverResponsibilityRating = 0f;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
    public Driver(User user) {
        this.user = user;
        isActive = false;
        driverStatus = "inactive";
        createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
    public Boolean toggleIsActive() {
        if (!driverStatus.equals("banned")) {
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
