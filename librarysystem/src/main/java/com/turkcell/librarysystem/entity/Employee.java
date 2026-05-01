package com.turkcell.librarysystem.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

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

    private String termOfOffice;

    public Employee() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTckn() { return tckn; }
    public void setTckn(String tckn) { this.tckn = tckn; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getTermOfOffice() { return termOfOffice; }
    public void setTermOfOffice(String termOfOffice) { this.termOfOffice = termOfOffice; }
}