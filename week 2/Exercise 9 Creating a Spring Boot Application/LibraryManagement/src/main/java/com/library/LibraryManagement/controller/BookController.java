package com.library.LibraryManagement.controller;

import com.library.LibraryManagement.entity.Book;
import com.library.LibraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> employees()
    {
        return bookService.findAll();
    }


    // expose endpoint to return single book
    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId)
    {
        Book theBook = bookService.getBook(bookId);

        // Throw exception for bad request
        if(theBook==null)
            throw new RuntimeException("Book Id not found--> "+bookId);


        return theBook;
    }

    // expose endpoint to add
    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook)
    {
        //Also just in case they pass an id in JSON... set id to 0
        // this is to force a save of new item instead of update

        theBook.setId(0);

        return bookService.addBook(theBook);

    }


    // expose endpoint to update
    @PutMapping("/books")
    public Book updateBook(@RequestBody Book theBook)
    {
        if(!bookService.updateBook(theBook))
            throw new RuntimeException("Book not updated--> "+theBook);


        return theBook;
    }


    //expose endpoint to delete
    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable Integer bookId)
    {
        Book theBook = bookService.getBook(bookId);

        if(theBook==null)
            throw new RuntimeException("Book not found--> "+bookId);
        bookService.deleteBook(bookId);

        return ("Book deleted with id--> "+ bookId);
    }


}
