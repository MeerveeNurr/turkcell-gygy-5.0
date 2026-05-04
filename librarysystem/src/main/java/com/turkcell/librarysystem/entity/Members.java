package com.turkcell.librarysystem.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "members")
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UuidGenerator
    @Column(name="id")
    private UUID id;

    @Column(unique = true)
    private String tckn;

    @Column(name="name",nullable=false,length=100)
    private String name;

    @Column(name="surname",nullable=false,length=100)
    private String surname;
    @Column(name="dateOfMembership",nullable = false)
    private LocalDate dateOfMembership;
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive;

    public Members() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTckn() { return tckn; }
    public void setTckn(String tckn) { this.tckn = tckn; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public LocalDate getDateOfMembership() { return dateOfMembership; }
    public void setDateOfMembership(LocalDate dateOfMembership) { this.dateOfMembership = dateOfMembership; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}