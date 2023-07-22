package com.example.letsgo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Integer paymentMethodId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") public User user;
    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY) public List<TripTransaction> tripTransactions;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'inactive'") public String paymentMethodStatus = "inactive";
    @Column(columnDefinition = "BOOLEAN DEFAULT false") public Boolean isValid = false;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''") public String paymentDetail = "";
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
}