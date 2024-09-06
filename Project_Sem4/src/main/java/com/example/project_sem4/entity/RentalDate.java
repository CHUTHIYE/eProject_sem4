package com.example.project_sem4.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RentalDate")
public class RentalDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentalDateId;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Getters and setters
}
