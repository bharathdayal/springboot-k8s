package com.example.demo.controllers;

import com.example.demo.model.Book;
import com.example.demo.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/book")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book saveBook = bookService.createBook(book);
        return new ResponseEntity<>(saveBook, HttpStatus.OK);
    }
}
