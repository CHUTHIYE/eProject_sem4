package com.example.project_sem4.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserRoleId implements Serializable {

    private Integer user;
    private Integer role;

    // Default constructor

    public UserRoleId() {}

    // Constructor with parameters
    public UserRoleId(Integer user, Integer role) {
        this.user = user;
        this.role = role;
    }

    // hashCode and equals methods

    @Override
    public int hashCode() {
        return Objects.hash(user, role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleId that = (UserRoleId) o;
        return Objects.equals(user, that.user) && Objects.equals(role, that.role);
    }
}
