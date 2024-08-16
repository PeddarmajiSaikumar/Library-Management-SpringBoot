package com.example.library_sace_study.controller;

import com.example.library_sace_study.exceptions.BookNotFoundException;
import com.example.library_sace_study.model.Book;
import com.example.library_sace_study.service.LibraryService;
import com.example.library_sace_study.service.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/books")
public class BookController {


    private final LibraryServiceImpl libraryService;

    @Autowired
    public BookController(LibraryServiceImpl libraryService) {
        this.libraryService = libraryService;
    }
//
//    @Autowired
//    private LibraryServiceImpl libraryService;

    @GetMapping
    public List<Book> getAllBooks(){
        return libraryService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return libraryService.getBookById(id)
                .map(book->new ResponseEntity<>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book createdBook=libraryService.saveBook(book);
        return new ResponseEntity<>(createdBook,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,@RequestBody Book book){
        Optional<Book> existingBook=libraryService.getBookById(id);
        if(existingBook.isPresent()){
            Book b1=existingBook.get();
            b1.setAuthor(book.getAuthor());
            b1.setIsbn(book.getIsbn());
            b1.setTitle(book.getTitle());
            return ResponseEntity.ok(b1);
        }else{
            throw new BookNotFoundException("Book Not Found");
        }
    }
}
