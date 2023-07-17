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
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer userId;
    String firstName;
    String lastName;
    String email = firstName + lastName + "@gmail.com";
    String password = firstName + lastName;
    Boolean isAdmin = false;
    String username = firstName + lastName;
    String userStatus = "inactive";
    Integer timesRated = 0;
    Float overallSafetyScore = 0f;
    Float overallSafetyRating = 0f;
    Float overallResponsibilityRating = 0f;
    Timestamp createdAt;
    Timestamp updatedAt;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false)
    Rider rider;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false)
    Driver driver;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@gmail.com";
        password = firstName.toLowerCase() + lastName.toLowerCase();
        isAdmin = false;
        username = firstName.toLowerCase() + lastName.toLowerCase();
        userStatus = "inactive";
        timesRated = 0;
        overallSafetyScore = 0f;
        overallSafetyRating = 0f;
        overallResponsibilityRating = 0f;
        createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
