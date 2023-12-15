package com.indiumsoft.paymentmicroservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;


}
