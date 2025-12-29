package com.examly.springapp.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Double amount;

    private String paymentMethod;

    @OneToOne
    private Booking booking;

    // getters & setters
}
