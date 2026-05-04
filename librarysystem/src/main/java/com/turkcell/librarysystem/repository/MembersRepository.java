package com.turkcell.librarysystem.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.librarysystem.entity.Members;

@Repository
public interface MembersRepository extends JpaRepository<Members,UUID>{

}