package com.turkcell.library_cqrs.persistance.repository;

import java.util.Optional;
import java.util.UUID;
import com.turkcell.library_cqrs.domain.Books;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Books,UUID> {
  Optional<Books> findByName(String name);
}
