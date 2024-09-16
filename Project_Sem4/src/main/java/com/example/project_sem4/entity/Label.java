package com.example.project_sem4.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Label")
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer labelId;

    @Column(length = 20)
    private String labelName;


    @OneToMany(mappedBy = "label", cascade = CascadeType.ALL)
    private Set<Product> products;

    // Getters and setters

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
