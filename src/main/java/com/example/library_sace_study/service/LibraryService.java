package com.example.library_sace_study.service;

import com.example.library_sace_study.model.Author;
import com.example.library_sace_study.model.Book;
import com.example.library_sace_study.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public interface LibraryService {

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(Long id);

    Author saveAuthor(Author author);

    void deleteAuthor(Long id);

    List<Book> getAllBooks();

    Optional<Book> getBookById(Long id);

    Book saveBook(Book book);

    void deleteBook(Long id);
}
