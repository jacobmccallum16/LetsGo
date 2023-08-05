package com.example.letsgo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverTripTransaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer driverTripTransactionId;
    // I'm keeping everything simple for the time being to avoid dealing with stack overflow errors
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "trip_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "driver", "route", "driver.getRider()", "driver.getRiderId()"}) private Trip trip;
//    private Integer tripId; // @OneToOne
    private String firstName = null;
    private String lastName = null;
    private String fullName = null;
    private Integer routeId; // @ManyToOne
    private Integer driverId; // @ManyToOne
    private Integer vehicleId; // @ManyToOne
    //    private Integer paymentMethodId; // @ManyToOne
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Planned'") private String driverTripTransactionStatus = "Planned"; // ["Planned", "Scheduled", "Pending", "Completed", "Processed"]
    @Column(columnDefinition = "FLOAT DEFAULT 0") private Float driverSafetyScore = 0f;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") private BigDecimal baseRateDistance = BigDecimal.valueOf(0.5);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") private BigDecimal baseRateDuration = BigDecimal.valueOf(0.5);
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") private BigDecimal baseRateMultiplier = BigDecimal.valueOf(1); // this is for future-proofing, eg. great drivers might get higher rate
    @Column(columnDefinition = "FLOAT DEFAULT 0") private Float distanceEstimated = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT 0") private Float distanceActual = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT 0") private Float durationEstimated = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT 0") private Float durationActual = 0f;
    @Column(columnDefinition = "INTEGER DEFAULT 1") private Integer passengers = 1;
    @Column(columnDefinition = "INTEGER DEFAULT 2") private Integer passengersMax = 2;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal multiPassengerMultiplier = BigDecimal.valueOf(1); // Probably something like [0, 0, 0.1, 0.15, 0.2, 0.25, 0.3]
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0.3") private BigDecimal multiPassengerMultiplierMax = BigDecimal.valueOf(1.3); // Probably something like [0, 0, 0.1, 0.15, 0.2, 0.25, 0.3]
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal distanceSubtotal; // AVG(distanceEst, distanceAct) * baseRateDistance * baseRateMultiplier
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal durationSubtotal; // AVG(durationEst, durationAct) * baseRateDuration * baseRateMultiplier
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal baseRateSubtotal; // SUM(distanceSubtotal, durationSubtotal)
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 1") private BigDecimal multiPassengerBonus; // baseRateSubtotal * multiPassengerSubtotal
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal multiPassengerBonusMax;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal preTripQuote;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal preTripQuoteMax;
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal tripTotal; // baseRateSubtotal + multiPassengerSubtotal
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal tipAmount; // all tips from passengers
    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0") private BigDecimal finalTotal; // initialTotal + tipAmount
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

    public DriverTripTransaction(Trip trip, Driver driver) {
        this.trip = trip;
        if (driver != null) {
            driverId = driver.getDriverId();
        }
        preTripCalculations(driver);
    }

    public void preTripCalculations(Driver driver) {
        driverTripTransactionStatus = trip.getTripStatus();


        passengers = trip.getPassengers();
        if (driver != null) {
            driverId = driver.getDriverId();
            driverSafetyScore = Math.round(driver.getDriverSafetyScore() * 10) / 10f;
            passengersMax = trip.getPassengersMax();
            firstName = driver.getFirstName();
            lastName = driver.getLastName();
            fullName = driver.getFullName();
        } else {
            driverId = null;
            driverSafetyScore = 0f;
            passengersMax = 6;
            firstName = null;
            lastName = null;
            fullName = null;
        }

//        if (driverSafetyScore >= 4) {
//            baseRateMultiplier = BigDecimal.valueOf(1.1);
//        } else if (driverSafetyScore >= 3 || driverSafetyScore == 0) {
//            baseRateMultiplier = BigDecimal.valueOf(1);
//        } else if (driverSafetyScore >= 2.5) {
//            baseRateMultiplier = BigDecimal.valueOf(0.9);
//        } else {
//            baseRateMultiplier = BigDecimal.valueOf(0.8);
//        }
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
            multiPassengerMultiplier = BigDecimal.valueOf( 0 + (passengers * 0.05) );
        } else {
            multiPassengerMultiplier = BigDecimal.valueOf(0.3);
        }
        if (passengersMax == 1) {
            multiPassengerMultiplierMax = BigDecimal.valueOf(0);
        } else if (passengersMax < 7) {
            multiPassengerMultiplierMax = BigDecimal.valueOf( 0 + (passengersMax * 0.05) );
        } else {
            multiPassengerMultiplierMax = BigDecimal.valueOf(0.3);
        }

        distanceSubtotal = BigDecimal.valueOf(((double) distanceEstimated * 0.5) + ((double) distanceActual * 0.5)).multiply(baseRateDistance).multiply(baseRateMultiplier);
        durationSubtotal = BigDecimal.valueOf(((double) durationEstimated * 0.5) + ((double) durationActual * 0.5)).multiply(baseRateDuration).multiply(baseRateMultiplier);
        baseRateSubtotal = distanceSubtotal.add(durationSubtotal);

        multiPassengerBonus = baseRateSubtotal.multiply(multiPassengerMultiplier);
        multiPassengerBonusMax = baseRateSubtotal.multiply(multiPassengerMultiplierMax);

        preTripQuote = baseRateSubtotal.add(multiPassengerBonus);
        preTripQuoteMax = baseRateSubtotal.add(multiPassengerBonusMax);

        tripTotal = BigDecimal.ZERO;
        tipAmount = BigDecimal.ZERO;
        finalTotal = BigDecimal.ZERO;
    }

}
