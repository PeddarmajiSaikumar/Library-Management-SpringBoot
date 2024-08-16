package com.example.library_sace_study.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String authorNotFound) {
        super(authorNotFound);
    }
}
