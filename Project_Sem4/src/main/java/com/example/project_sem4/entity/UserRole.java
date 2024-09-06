package com.example.project_sem4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "User_Role")
@IdClass(UserRoleId.class)
public class UserRole {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    // Getters and setters
}
