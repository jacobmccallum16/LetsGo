package com.example.letsgo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer tripId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "route_id") @JsonIgnoreProperties({"hibernateLazyInitializer"}) private Route route;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "driver_id") @JsonIgnoreProperties({"hibernateLazyInitializer"}) private Driver driver;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "vehicle_id") @JsonIgnoreProperties({"hibernateLazyInitializer"}) private Vehicle vehicle;
//    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY) private List<TripTransaction> tripTransaction;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<RiderRating> riderRatings;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<DriverRating> driverRatings;
    @Column(columnDefinition = "INTEGER DEFAULT 2") public Integer passengersMax = 2;
    @Column(columnDefinition = "INTEGER DEFAULT 0") public Integer passengers = 0;
    @Column(columnDefinition = "INTEGER DEFAULT 0") public Integer seatsLeft = 0;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Planned'") public String tripStatus = "Planned";
    @ManyToMany(mappedBy = "requestedTrips") public Set<User> requestingUsers;
    @Column(columnDefinition = "DATETIME") public LocalDateTime departureTime;
    @Column(columnDefinition = "DATETIME") public LocalDateTime arrivalTime;
    private Float tripDistanceEstimated = 0f;
    private Float tripDistanceActual = 0f;
    private Float tripDurationEstimated = 0f;
    private Float tripDurationActual = 0f;
    private String tripImageSource = "";
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

    public Trip(Route route) {
        this.route = route;
        tripDistanceEstimated = route.getRouteDistance();
        tripDistanceActual = route.getRouteDistance();
        tripDurationEstimated = route.getRouteDuration();
        tripDurationActual = route.getRouteDuration();
        tripImageSource = route.getRouteImageSource();
    }
    public Integer getRouteId() {
        return getRoute().getRouteId();
    }
    public Integer getDriverId() {
        return getDriver().getDriverId();
    }
    public void calculateArrivalTime() {
        arrivalTime = departureTime.plusMinutes(tripDurationActual.longValue());
        return;
    }
    public String printDateTime(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("ccc, MMMM d, hh:mm a"));
    }
    public String printDate(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("ccc, MMMM d"));
    }
    public String printTime(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    public static void sortByDateAndTime(List<Trip> trips) {
        trips.sort(Comparator.comparing(Trip::getDepartureTime).thenComparing(Trip::getArrivalTime));
    }
    public static void sortByRouteId(List<Trip> trips) {
        trips.sort(Comparator.comparing(Trip::getRouteId));
    }

}