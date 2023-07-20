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
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "trip_id") Trip trip;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "route_id") Route route;
    // User user
    // PaymentMethod paymentMethod
    @Column(columnDefinition = "BOOLEAN DEFAULT false") Boolean isDriver = false;
    // Decimal baseRate;
    @Column(columnDefinition = "FLOAT DEFAULT 0") Float tripDistance = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT 0") Float tripDuration = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT 1") Float surgePercent = 1f;
    @Column(columnDefinition = "FLOAT DEFAULT 1") Float multipassengerAdjustment = 1f;
    // Decimal distanceFee;
    // Decimal durationFee;
    // Decimal multipassengerDiscount;
    // Decimal subtotal;
    // Decimal taxRate;
    // Decimal taxAmount;
    // Decimal total;
    // Decimal tipAmount;
    // Decimal finalPrice;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;
}