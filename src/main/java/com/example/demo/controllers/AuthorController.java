package com.example.demo.controllers;

import com.example.demo.model.Author;
import com.example.demo.services.AuthorService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/author")
@AllArgsConstructor
public class AuthorController {

    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author saveAuthor=authorService.createAuthor(author);
        return new ResponseEntity<>(saveAuthor, HttpStatus.OK);
    }
}
