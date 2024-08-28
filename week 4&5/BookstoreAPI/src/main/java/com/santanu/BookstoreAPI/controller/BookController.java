package com.santanu.BookstoreAPI.controller;


import com.santanu.BookstoreAPI.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping("/all")
    public ResponseEntity<Book> getAllBooks(){
        Book book = new Book();
       return ResponseEntity.ok(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book = new Book();
        return ResponseEntity.ok(book);
    }

    @PostMapping()
    public ResponseEntity<Book> addBook(@RequestBody Book book){

        return ResponseEntity.ok(book);
    }

    @PutMapping()
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deletebook(@PathVariable Long id){
        Book book = new Book();
        return ResponseEntity.ok(book);
    }
}
