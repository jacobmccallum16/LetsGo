package com.example.letsgov1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer userId;
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
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) Rider rider;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) Driver driver;

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

}
