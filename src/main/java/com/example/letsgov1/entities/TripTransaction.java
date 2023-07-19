package com.example.letsgov1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TripTransaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer tripTransactionId;
    // Trip trip
    // User user
    // PaymentMethod paymentMethod
    Boolean isDriver = false;
    // Decimal baseRate;
    Float tripDistance = 0f;
    Float tripDuration = 0f;
    Float surgePercent;
    Float multipassengerAdjustment;
    // Decimal distanceFee;
    // Decimal durationFee;
    // Decimal multipassengerDiscount;
    // Decimal subtotal;
    // Decimal taxRate;
    // Decimal taxAmount;
    // Decimal total;
    // Decimal tipAmount;
    // Decimal finalPrice;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") Float driverResponsibilityRating = 0f;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;
}