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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean isAdmin = false;
    private String username;
    private String userStatus = "inactive";
    private Integer timesRated = 0;
    private Double overallSafetyScore = 0.0;
    private Double overallSafetyRating = 0.0;
    private Double overallResponsibilityRating = 0.0;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
