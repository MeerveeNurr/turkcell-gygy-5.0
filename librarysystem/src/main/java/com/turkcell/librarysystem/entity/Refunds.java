package com.turkcell.librarysystem.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;

@Entity
@Table(name = "refunds")
public class Refunds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @UuidGenerator
    @Column(name="id")
    private UUID id;
    
     @Column(name="returnedBookName",nullable=false,length=100)
    private String returnedBookName;

    private int dueDay;
    private int delayTime;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Members returningMember;

    @ManyToOne
    @JoinColumn(name = "lend_id")
    private Lends lend;

    public Refunds() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getReturnedBookName() { return returnedBookName; }
    public void setReturnedBookName(String returnedBookName) { this.returnedBookName = returnedBookName; }

    public int getDueDay() { return dueDay; }
    public void setDueDay(int dueDay) { this.dueDay = dueDay; }

    public int getDelayTime() { return delayTime; }
    public void setDelayTime(int delayTime) { this.delayTime = delayTime; }

    public Members getReturningMember() { return returningMember; }
    public void setReturningMember(Members returningMember) { this.returningMember = returningMember; }

    public Lends getLend() { return lend; }
    public void setLend(Lends lend) { this.lend = lend; }
}