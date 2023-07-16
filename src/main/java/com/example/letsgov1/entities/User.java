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
    private Boolean isAdmin;
    private String username;
    private String userStatus;
    private Integer timesRated;
    private Double overallSafetyScore;
    private Double overallSafetyRating;
    private Double overallResponsibilityRating;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
