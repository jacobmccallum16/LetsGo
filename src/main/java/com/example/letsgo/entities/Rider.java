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
public class Rider {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Integer riderId;
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") @JsonIgnoreProperties({"hibernateLazyInitializer"}) public User user;
    @OneToMany(mappedBy = "ratedRider", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<RiderRating> riderRatings;
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE") public Boolean isActive = false;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Inactive'") public String riderStatus = "Inactive";
    @Column(columnDefinition = "INTEGER DEFAULT '0'") public Integer tripsTaken = 0;
    @Column(columnDefinition = "INTEGER DEFAULT '0'") public Integer timesRated = 0;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") public Float riderSafetyScore = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") public Float riderSafetyRating = 0f;
    @Column(columnDefinition = "FLOAT DEFAULT '0'") public Float riderResponsibilityRating = 0f;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
    public Rider(User user) {
        this.user = user;
        isActive = false;
        riderStatus = "Inactive";
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
    public Integer getDriverId() { return getUser().getDriver().getDriverId(); }
    public static void sortByFullName(List<Rider> riders) {
        riders.sort(Comparator.comparing(Rider::getLastName).thenComparing(Rider::getFirstName));
    }

    public Boolean toggleIsActive() {
        if (!riderStatus.equals("Banned")) {
            if (!isActive) {
                isActive = true;
                riderStatus = "Active";
            } else {
                isActive = false;
                riderStatus = "Inactive";
            }
        } else {
            isActive = false;
        }
        updatedAt = new Timestamp(System.currentTimeMillis());
        return isActive;
    }
    public void updateStatus(String riderStatus) {
        this.riderStatus = riderStatus;
        if (riderStatus.equals("Active")) {
            isActive = true;
        } else {
            isActive = false;
        }
    }
    public void updateStatus() {
        isActive = riderStatus.equals("Active");
    }
    public void updateUpdatedAt() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    // simplified methods for temporary use:
    public void updateSafetyScore() {
        if (timesRated > 0) {
            riderSafetyScore = (1 + riderSafetyRating + riderResponsibilityRating);
        }
    }
}
