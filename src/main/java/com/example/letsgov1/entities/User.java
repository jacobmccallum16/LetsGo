package com.example.letsgov1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer userId;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public Rider rider;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public Driver driver;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<PaymentMethod> paymentMethods;
    @OneToMany(mappedBy = "ratedByUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<DriverRating> driverRatings;
    @OneToMany(mappedBy = "ratedByUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<RiderRating> riderRatings;
    String firstName;
    String lastName;
    String email;
    String password;
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE") Boolean isAdmin = false;
    String username;
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE") Boolean isActive = false;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'inactive'") String userStatus = "inactive";
    @Column(columnDefinition = "INTEGER DEFAULT '0'") Integer timesRated = 0;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") Float overallSafetyScore = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") Float overallSafetyRating = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") Float overallResponsibilityRating = 0f;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;

    public Boolean updateIsActive() {
        if (userStatus != "banned") {
            if (rider.isActive || driver.isActive) {
                isActive = true;
                userStatus = "active";
            } else {
                isActive = false;
                userStatus = "inactive";
            }
        } else {
            isActive = false;
            userStatus = "banned";
        }
        updatedAt = new Timestamp(System.currentTimeMillis());
        return isActive;
    }

    public void updateAllTimestamps() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        updatedAt = timestamp;
        rider.setUpdatedAt(timestamp);
        driver.setUpdatedAt(timestamp);
    }

}
