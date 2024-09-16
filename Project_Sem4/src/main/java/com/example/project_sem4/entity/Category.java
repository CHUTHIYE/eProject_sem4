package com.example.project_sem4.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(length = 100)
    private String categoryName;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products;

    // Getters and setters
    public Category() {}

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

