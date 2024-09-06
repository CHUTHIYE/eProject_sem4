package com.example.project_sem4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogId;

    @Lob
    private String blogContent;

    // Getters and setters
}
