package com.example.project_sem4.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(nullable = false, length = 50)
    private String roleName;


    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    // Getters and setters
}
