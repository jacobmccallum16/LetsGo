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
public class RiderTripTransaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer riderTripTransactionId;
    private Integer riderId; // @ManyToOne
    private Integer tripId; // @OneToMany??
    private Integer routeId; // @ManyToOne
    //    private Integer paymentMethodId; // @ManyToOne
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Potential'") private String driverTripTransactionStatus = "Potential"; // ["Potential", "Planned", "Pending", "Completed", "Processed"]
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") private BigDecimal baseRateDistance = BigDecimal.valueOf(0.5);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") private BigDecimal baseRateDuration = BigDecimal.valueOf(0.5);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") private BigDecimal baseRateMultiplier = BigDecimal.valueOf(1); // this is for future-proofing, eg. impolite rider might get charged more;
    private Float tripDistanceEstimated;
    private Float tripDistanceActual; // not involved in calculation currently, it's for the future when detours are added to pick additional customers
    private Float tripDurationEstimated;
    private Float tripDurationActual; // not involved in calculation currently, it's for the future when detours are added to pick additional customers
    private Integer passengers = 1;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") private BigDecimal multiPassengerMultiplier = BigDecimal.valueOf(1); // Probably something like [0, 1, 0.9, 0.85, 0.8, 0.75, 0.7]
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal distanceSubtotal; // distanceEst * baseRateDistance * baseRateMultiplier
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal durationSubtotal; // durationEst * baseRateDuration * baseRateMultiplier
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal preTripQuote;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal multiPassengerPotentialBonus; // preTripQuote * 0.7 or something
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal preTripQuoteBest;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal multiPassengerBonus; // preTripQuote * multiPassengerSubtotal
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal initialTotal; // baseRateSubtotal + multiPassengerSubtotal
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal tipAmount; // all tips from passengers
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal finalTotal; // initalTotal + tipAmount
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
}
