package com.turkcell.librarysystem.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;

@Entity
@Table(name = "punishments")
public class Punishments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @UuidGenerator
    @Column(name="id")
    private UUID id;

     @Column(name="nameOfPenalizedMember",nullable=false,length=100)
    private String nameOfPenalizedMember;

    private boolean isPunishmentPay;

    @ManyToOne
    @JoinColumn(name = "lend_id")
    private Lends penalizedLend;

    public Punishments() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNameOfPenalizedMember() { return nameOfPenalizedMember; }
    public void setNameOfPenalizedMember(String nameOfPenalizedMember) { this.nameOfPenalizedMember = nameOfPenalizedMember; }

    public boolean isPunishmentPay() { return isPunishmentPay; }
    public void setPunishmentPay(boolean punishmentPay) { isPunishmentPay = punishmentPay; }

    public Lends getPenalizedLend() { return penalizedLend; }
    public void setPenalizedLend(Lends penalizedLend) { this.penalizedLend = penalizedLend; }
}