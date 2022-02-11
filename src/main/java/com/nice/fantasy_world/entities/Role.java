package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "number", nullable = false)
    private int number;
    @Basic
    @Column(name = "role_key", nullable = false, length = 255)
    private String roleKey;
    @Basic
    @Column(name = "permissions", nullable = false, length = 2000)
    private String permissions;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return number == role.number && Objects.equals(roleKey, role.roleKey) && Objects.equals(permissions, role.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, roleKey, permissions);
    }
}
