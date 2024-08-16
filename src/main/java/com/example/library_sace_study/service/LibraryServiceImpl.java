package com.example.library_sace_study.service;

import com.example.library_sace_study.model.Author;
import com.example.library_sace_study.model.Book;
import com.example.library_sace_study.repository.AuthorRepository;
import com.example.library_sace_study.repository.BookRepository;
import org.hibernate.annotations.DialectOverride;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public LibraryServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
        public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Long id){
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        return optionalAuthor;
    }

    @Override
    public Author saveAuthor(Author author){
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id){
        Optional<Book> optionalBook=bookRepository.findById(id);
        return optionalBook;
    }

    @Override
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
