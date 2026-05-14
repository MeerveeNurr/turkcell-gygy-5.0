package com.turkcell.spring_cqrs.domain;

import org.hibernate.annotations.UuidGenerator;

import com.turkcell.spring_cqrs.core.security.authorization.Role;

import java.util.UUID; 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")

public class User {
    @Id
    @UuidGenerator
    @Column(name="id")
    private UUID id;
    @Column(name="email",nullable=false,unique=true)
    private String email;
    @Column(name="password", nullable = false)
    private String password;
    
    @Enumerated(EnumType.STRING) // Veritabanına "ADMIN" veya "USER" yazması için
    @Column(name="role")
    private Role role;


    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

}
