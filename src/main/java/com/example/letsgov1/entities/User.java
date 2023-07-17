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

    public void setRider(Rider rider) {
        if (rider == null) {
            if (this.rider != null) {
                this.rider.setUser(null);
            }
        }
        else {
            rider.setUser(this);
        }
        this.rider = rider;
    }

}
