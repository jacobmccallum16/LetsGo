package com.example.letsgo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TripTransaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Integer tripTransactionId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "trip_id") public Trip trip;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "route_id") public Route route;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") public User user;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "payment_method_id") public PaymentMethod paymentMethod;
    @Column(columnDefinition = "BOOLEAN DEFAULT false") public Boolean isDriver = false;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 2") public BigDecimal baseRate = BigDecimal.valueOf(2.0);
    @Column(columnDefinition = "FLOAT DEFAULT 0") public Float tripDistance = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT 0") public Float tripDuration = 0f;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") public BigDecimal surgePercent = BigDecimal.valueOf(1);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") public BigDecimal multipassengerAdjustment = BigDecimal.valueOf(1);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") public BigDecimal distanceFee = BigDecimal.valueOf(0.0);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") public BigDecimal durationFee = BigDecimal.valueOf(0.0);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") public BigDecimal multipassengerDiscount = BigDecimal.valueOf(0.0);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") public BigDecimal subtotal = BigDecimal.valueOf(0.0);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1.12") public BigDecimal taxRate = BigDecimal.valueOf(1.12);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") public BigDecimal taxAmount = BigDecimal.valueOf(0.0);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") public BigDecimal total = BigDecimal.valueOf(0.0);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") public BigDecimal tipAmount = BigDecimal.valueOf(0.0);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") public BigDecimal finalPrice = BigDecimal.valueOf(0.0);
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
}