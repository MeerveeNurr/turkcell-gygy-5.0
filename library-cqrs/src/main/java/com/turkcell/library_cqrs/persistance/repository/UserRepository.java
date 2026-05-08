package com.turkcell.library_cqrs.persistance.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.library_cqrs.domain.Employee;

public interface UserRepository extends JpaRepository<Employee,UUID> {
     Optional<Employee> findByEmail(String email);
}
