package com.example.library_sace_study.repository;

import com.example.library_sace_study.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
