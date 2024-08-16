package com.example.library_sace_study.controller;

import com.example.library_sace_study.exceptions.AuthorNotFoundException;
import com.example.library_sace_study.model.Author;
import com.example.library_sace_study.model.Book;
import com.example.library_sace_study.repository.AuthorRepository;
import com.example.library_sace_study.service.LibraryService;
import com.example.library_sace_study.service.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final LibraryServiceImpl libraryService;

    @Autowired
    public AuthorController(LibraryServiceImpl libraryService) {
        this.libraryService = libraryService;
    }

//    @Autowired
//    private LibraryServiceImpl libraryService;

    @GetMapping
    public List<Author> getAllAuthors(){
        return libraryService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
        return libraryService.getAuthorById(id)
                .map(author->new ResponseEntity<>(author, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        Author createdAuthor=libraryService.saveAuthor(author);
        return new ResponseEntity<>(createdAuthor,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        Optional<Author> existingAuthor=libraryService.getAuthorById(id);
        if(existingAuthor.isPresent()){
            Author a1=existingAuthor.get();
            a1.setName(author.getName());
            a1.setBooks(author.getBooks());
            return ResponseEntity.ok(a1);
        }else{
            throw new AuthorNotFoundException("Author Not Found");
        }
    }


   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id){
      libraryService.deleteAuthor(id);
      return ResponseEntity.noContent().build();
   }
}