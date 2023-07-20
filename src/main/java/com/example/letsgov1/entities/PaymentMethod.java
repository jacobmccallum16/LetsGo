package com.example.letsgov1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer paymentMethodId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") User user;
    String paymentMethodStatus = "primary";
    @Column(columnDefinition = "BOOLEAN DEFAULT false") Boolean isValid = false;
    // PaymentDetail paymentDetail;
    String paymentDetail;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") Timestamp updatedAt;
}