package com.example.letsgo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer userId;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) @JsonIgnoreProperties({"hibernateLazyInitializer", "user", "driver"}) private Rider rider;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) @JsonIgnoreProperties({"hibernateLazyInitializer", "user", "rider"}) private Driver driver;
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
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Inactive'") public String userStatus = "Inactive";
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
        if (!userStatus.equals("Banned")) {
            if (rider.isActive || driver.getIsActive()) {
                isActive = true;
                userStatus = "Active";
            } else {
                isActive = false;
                userStatus = "Inactive";
            }
        } else {
            isActive = false;
            userStatus = "Banned";
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

    public String getFullName() {
        return firstName + " " + lastName;
    }
    public static void sortByFullName(List<User> users) {
        users.sort(Comparator.comparing(User::getLastName).thenComparing(User::getFirstName));
    }

}
