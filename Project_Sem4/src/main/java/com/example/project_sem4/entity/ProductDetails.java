package com.example.project_sem4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductDetails")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detailId;

    @Column(length = 50)
    private String attributeName;

    @Column(length = 50)
    private String attributeValue;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Getters and setters
}
