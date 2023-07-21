package com.example.letsgov1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Integer userId;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public Rider rider;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public Driver driver;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<TripTransaction> tripTransaction;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<PaymentMethod> paymentMethods;
    @OneToMany(mappedBy = "ratedByUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<DriverRating> driverRatings;
    @OneToMany(mappedBy = "ratedByUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<RiderRating> riderRatings;
    @ManyToMany @JoinTable(
            name = "user_route",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id")
    )
    public Set<Route> requestedRoutes;
    @ManyToMany @JoinTable(
            name = "user_trip",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id")
    )
    public Set<Trip> requestedTrips;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String firstName = "";
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String lastName = "";
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String email = "";
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String password = "";
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE") public Boolean isAdmin = false;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String username = "";
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE") public Boolean isActive = false;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'inactive'") public String userStatus = "inactive";
    @Column(columnDefinition = "INTEGER DEFAULT '0'") public Integer timesRated = 0;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") public Float overallSafetyScore = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") public Float overallSafetyRating = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") public Float overallResponsibilityRating = 0f;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

    public User(String admin) {
        this.firstName = admin;
        this.lastName = admin;
        this.email = admin + "@localhost";
        this.password = admin;
        this.username = admin;
        this.isAdmin = true;
        this.rider = new Rider(this);
        this.driver = new Driver(this);
        this.updateAllTimestamps();
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        var temp = firstName.toLowerCase() + lastName.toLowerCase();
        this.email = temp + "@gmail.com";
        this.password = temp;
        this.username = temp;
        this.rider = new Rider(this);
        this.driver = new Driver(this);
        this.updateAllTimestamps();
    }

    public Boolean updateIsActive() {
        if (!userStatus.equals("banned")) {
            if (rider.isActive || driver.isActive) {
                isActive = true;
                userStatus = "active";
            } else {
                isActive = false;
                userStatus = "inactive";
            }
        } else {
            isActive = false;
            userStatus = "banned";
        }
        updatedAt = new Timestamp(System.currentTimeMillis());
        return isActive;
    }

    public void updateAllTimestamps() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        updatedAt = timestamp;
        rider.setUpdatedAt(timestamp);
        driver.setUpdatedAt(timestamp);
    }
    public String getRole() {
        if (isAdmin) {
            return "ROLE_ADMIN";
        } else {
            return "ROLE_USER";
        }
    }

}
