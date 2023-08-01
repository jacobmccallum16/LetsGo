package com.example.letsgo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TripRider {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer tripRiderId;
    private Integer tripId;
    private Integer riderId;
    private String fullName;

    public TripRider(Integer tripId, Integer riderId) {
        this.tripId = tripId;
        this.riderId = riderId;
    }
    public TripRider(Integer tripId, Integer riderId, String fullName) {
        this.tripId = tripId;
        this.riderId = riderId;
        this.fullName = fullName;
    }
}
