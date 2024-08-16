package com.example.library_sace_study.repository;

import com.example.library_sace_study.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
