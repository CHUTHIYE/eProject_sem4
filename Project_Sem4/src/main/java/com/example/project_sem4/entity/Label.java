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
}
