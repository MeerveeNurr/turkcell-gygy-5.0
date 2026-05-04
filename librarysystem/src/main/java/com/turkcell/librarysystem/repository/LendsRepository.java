package com.turkcell.librarysystem.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.librarysystem.entity.Lends;

@Repository
public interface LendsRepository extends JpaRepository<Lends,UUID>{

}