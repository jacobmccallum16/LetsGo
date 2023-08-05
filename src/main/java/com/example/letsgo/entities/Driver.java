package com.example.letsgo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer driverId;
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") @JsonIgnoreProperties({"hibernateLazyInitializer", "driver", "rider"}) private User user;
//    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY) private List<Vehicle> vehicle;
    @OneToMany(mappedBy = "ratedDriver", cascade = CascadeType.ALL, fetch = FetchType.LAZY) private List<DriverRating> driverRatings;
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE") private Boolean isActive = false;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Inactive'") private String driverStatus = "Inactive";
    @Column(columnDefinition = "INTEGER DEFAULT 0") private Integer tripsDriven = 0;
    @Column(columnDefinition = "INTEGER DEFAULT '0'") private Integer timesRated = 0;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") private Float driverSafetyScore = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") private Float driverSafetyRating = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") private Float driverResponsibilityRating = 0f;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") private Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
    public Driver(User user) {
        setUser(user);
        isActive = false;
        driverStatus = "Inactive";
        createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public String getFullName() {
        return getUser().getFullName();
    }
    public String getFirstName() {
        return getUser().getFirstName();
    }
    public String getLastName() {
        return getUser().getLastName();
    }
    public Integer getRiderId() { return getUser().getRider().getRiderId(); }
    public static void sortByFullName(List<Driver> drivers) {
        drivers.sort(Comparator.comparing(Driver::getLastName).thenComparing(Driver::getFirstName));
    }

    public Boolean toggleIsActive() {
        if (!driverStatus.equals("Banned")) {
            if (!isActive) {
                isActive = true;
                driverStatus = "Active";
            } else {
                isActive = false;
                driverStatus = "Inactive";
            }
        } else {
            isActive = false;
        }
        updatedAt = new Timestamp(System.currentTimeMillis());
        return isActive;
    }

    public void updateStatus() {
        isActive = driverStatus.equals("Active");
    }
    public void updateUpdatedAt() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    // simplified methods for temporary use:
    public void updateSafetyScore() {
        if (timesRated > 0) {
            driverSafetyScore = (1 + driverSafetyRating + driverResponsibilityRating);
        }
    }

//    public static void sortByName(List<Driver> drivers) {
//        Collections.sort(drivers, Comparator.comparing(Driver::getUser::).thenComparing(Driver::getDepartureTime));
//    }

}
