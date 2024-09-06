package com.example.project_sem4.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 20)
    private String status;

    @Column(length = 20)
    private String duration;

    @Column(precision = 10, scale = 2)
    private Double price;

    private Integer quantity;


    @ManyToOne
    @JoinColumn(name = "label_id", nullable = true)
    private Label label;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductDetails> productDetails;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Image> images;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Feedback> feedbacks;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<RentalDate> rentalDates;

    // Getters and setters
}
