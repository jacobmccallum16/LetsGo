package com.example.letsgo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Integer tripId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "route_id") @JsonIgnoreProperties({"hibernateLazyInitializer"}) public Route route;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "driver_id") @JsonIgnoreProperties({"hibernateLazyInitializer"}) public Driver driver;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "vehicle_id") @JsonIgnoreProperties({"hibernateLazyInitializer"}) public Vehicle vehicle;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY) private List<TripTransaction> tripTransaction;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<RiderRating> riderRatings;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<DriverRating> driverRatings;
    @Column(columnDefinition = "INTEGER DEFAULT 0") public Integer seatsAvailable = 0;
    @Column(columnDefinition = "INTEGER DEFAULT 0") public Integer seatsUsed = 0;
    @ManyToMany(mappedBy = "riderTrips") public Set<Rider> riderSet;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Planned'") public String tripStatus = "Planned";
    @ManyToMany(mappedBy = "requestedTrips") public Set<User> requestingUsers;
    @Column(columnDefinition = "DATE") public LocalDate date;
    @Column(columnDefinition = "TIME") public LocalTime departureTime;
    @Column(columnDefinition = "TIME") public LocalTime arrivalTime;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String tripImageSource = "";
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

    public Trip(Route route) {
        this.route = route;
    }
    public Integer getRouteId() {
        return getRoute().getRouteId();
    }
    public void calculateArrivalTime() {
        long duration = (long) route.routeDuration;
        arrivalTime = departureTime.plusMinutes(duration);
        return;
    }

    public static void sortByDateAndTime(List<Trip> trips) {
        trips.sort(Comparator.comparing(Trip::getDate).thenComparing(Trip::getDepartureTime));
    }
    public static void sortByRouteId(List<Trip> trips) {
        trips.sort(Comparator.comparing(Trip::getRouteId));
    }
}