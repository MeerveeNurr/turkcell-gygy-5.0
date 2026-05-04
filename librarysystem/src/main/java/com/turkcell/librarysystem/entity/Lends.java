package com.turkcell.librarysystem.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "lends")
public class Lends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @UuidGenerator
    @Column(name="id")
    private UUID id;

     @Column(name="lendBookName",nullable=false,length=100)
    private String lendBookName;
    @Column(name="dateOfLend",nullable = false)
    
    private LocalDate dateOfLend;
    
    @Column(name="endOfLend",nullable = true)
    private LocalDate endOfLend;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Members member;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Books book;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Lends() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getLendBookName() { return lendBookName; }
    public void setLendBookName(String lendBookName) { this.lendBookName = lendBookName; }

    public LocalDate getDateOfLend() { return dateOfLend; }
    public void setDateOfLend(LocalDate dateOfLend) { this.dateOfLend = dateOfLend; }

    public LocalDate getEndOfLend() { return endOfLend; }
    public void setEndOfLend(LocalDate endOfLend) { this.endOfLend = endOfLend; }

    public Members getMember() { return member; }
    public void setMember(Members member) { this.member = member; }

    public Books getBook() { return book; }
    public void setBook(Books book) { this.book = book; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}