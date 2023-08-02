package com.example.letsgo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "trip_id") @JsonIgnoreProperties({"hibernateLazyInitializer"}) private Trip trip;
    private Integer riderId; // @ManyToOne
    private Integer routeId; // @ManyToOne
    private Integer driverId;
    //    private Integer paymentMethodId; // @ManyToOne
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Planned'") private String riderTripTransactionStatus = "Planned"; // ["Planned", "Scheduled", "Pending", "Completed", "Processed"]
    @Column(columnDefinition = "FLOAT DEFAULT 0") private Float riderSafetyScore = 0f;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") private BigDecimal baseRateDistance = BigDecimal.valueOf(0.5);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") private BigDecimal baseRateDuration = BigDecimal.valueOf(0.5);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") private BigDecimal baseRateMultiplier = BigDecimal.valueOf(1); // this is for future-proofing, eg. impolite rider might get charged more;
    @Column(columnDefinition = "FLOAT DEFAULT 0") private Float distanceEstimated = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT 0") private Float distanceActual = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT 0") private Float durationEstimated = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT 0") private Float durationActual = 0f;
    @Column(columnDefinition = "INTEGER DEFAULT 1") private Integer passengers = 1;
    @Column(columnDefinition = "INTEGER DEFAULT 2") private Integer passengersMax = 2;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") private BigDecimal multiPassengerMultiplier = BigDecimal.valueOf(1); // Probably something like [0, 1, 0.9, 0.85, 0.8, 0.75, 0.7]
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1.3") private BigDecimal multiPassengerMultiplierMax = BigDecimal.valueOf(1.3); // Probably something like [0, 1, 0.9, 0.85, 0.8, 0.75, 0.7]
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal distanceSubtotal; // AVG(distanceEst, distanceAct) * baseRateDistance * baseRateMultiplier
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal durationSubtotal; // AVG(durationEst, durationAct) * baseRateDuration * baseRateMultiplier
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal baseRateSubtotal; // SUM(distanceSubtotal, durationSubtotal)
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") private BigDecimal multiPassengerDiscount; // baseRateSubtotal * multiPassengerSubtotal
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal multiPassengerDiscountMax;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal preTripQuote;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal preTripQuoteMax;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal tripTotal; // baseRateSubtotal + multiPassengerSubtotal
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal tipAmount; // tip to driver
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal finalTotal; // initialTotal + tipAmount
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

    public RiderTripTransaction(Trip trip, Rider rider) {
        this.trip = trip;
        riderId = rider.riderId;
        preTripCalculations(rider);
    }


    public void preTripCalculations(Rider rider) {
        riderTripTransactionStatus = trip.getTripStatus();

        passengers = trip.getPassengers();
        if (trip.getDriver() != null) {
            driverId = trip.getDriverId();
            passengersMax = trip.getPassengersMax();
        } else {
            driverId = null;
            passengersMax = 6;
        }
        riderSafetyScore = rider.getRiderSafetyScore();

        baseRateMultiplier = BigDecimal.ONE;

        baseRateDistance = BigDecimal.valueOf(0.5);
        baseRateDuration = BigDecimal.valueOf(0.5);

        distanceEstimated = trip.getTripDistanceEstimated();
        distanceActual = trip.getTripDistanceActual();
        durationEstimated = trip.getTripDurationEstimated();
        durationActual = trip.getTripDurationActual();

        if (passengers == 1) {
            multiPassengerMultiplier = BigDecimal.valueOf(0);
        } else if (passengers < 7) {
            multiPassengerMultiplier = BigDecimal.valueOf(passengers * 0.05);
        } else {
            multiPassengerMultiplier = BigDecimal.valueOf(0.3);
        }
        if (passengersMax == 1) {
            multiPassengerMultiplierMax = BigDecimal.valueOf(0);
        } else if (passengersMax < 7) {
            multiPassengerMultiplierMax = BigDecimal.valueOf(passengersMax * 0.05);
        } else {
            multiPassengerMultiplierMax = BigDecimal.valueOf(0.3);
        }

        distanceSubtotal = BigDecimal.valueOf(((double) distanceEstimated * 0.5) + ((double) distanceActual * 0.5)).multiply(baseRateDistance).multiply(baseRateMultiplier);
        durationSubtotal = BigDecimal.valueOf(((double) durationEstimated * 0.5) + ((double) durationActual * 0.5)).multiply(baseRateDuration).multiply(baseRateMultiplier);
        baseRateSubtotal = distanceSubtotal.add(durationSubtotal);

        multiPassengerDiscount = baseRateSubtotal.multiply(multiPassengerMultiplier);
        multiPassengerDiscountMax = baseRateSubtotal.multiply(multiPassengerMultiplierMax);

        preTripQuote = baseRateSubtotal.subtract(multiPassengerDiscount);
        preTripQuoteMax = baseRateSubtotal.subtract(multiPassengerDiscountMax);

        tripTotal = BigDecimal.valueOf(0);
        tipAmount = BigDecimal.valueOf(0);
        finalTotal = BigDecimal.valueOf(0);
    }



}
