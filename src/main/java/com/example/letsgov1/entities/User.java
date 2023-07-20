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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Integer userId;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public Rider rider;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public Driver driver;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<TripTransaction> tripTransaction;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<PaymentMethod> paymentMethods;
    @OneToMany(mappedBy = "ratedByUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<DriverRating> driverRatings;
    @OneToMany(mappedBy = "ratedByUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<RiderRating> riderRatings;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String firstName = "";
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String lastName = "";
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String email = "";
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String password = "";
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE") public Boolean isAdmin = false;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String username = "";
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE") public Boolean isActive = false;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'inactive'") public String userStatus = "inactive";
    @Column(columnDefinition = "INTEGER DEFAULT '0'") public Integer timesRated = 0;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") public Float overallSafetyScore = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") public Float overallSafetyRating = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") public Float overallResponsibilityRating = 0f;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

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
