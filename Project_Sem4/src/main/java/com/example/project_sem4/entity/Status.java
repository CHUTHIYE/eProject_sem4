package com.example.project_sem4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statusId;

    @Column(length = 50)
    private String statusName;

    @Column(length = 10)
    private String type;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

    // Getters and setters
}
