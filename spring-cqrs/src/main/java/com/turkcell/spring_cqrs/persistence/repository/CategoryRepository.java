package com.turkcell.spring_cqrs.persistence.repository;

import java.util.Optional;
import java.util.UUID;
import com.turkcell.spring_cqrs.domain.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,UUID> {
  Optional<Category> findByName(String name);
}
