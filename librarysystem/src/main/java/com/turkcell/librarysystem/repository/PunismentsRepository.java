package com.turkcell.librarysystem.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.librarysystem.entity.Punishments;

@Repository
public interface PunismentsRepository extends JpaRepository<Punishments,UUID>{

}