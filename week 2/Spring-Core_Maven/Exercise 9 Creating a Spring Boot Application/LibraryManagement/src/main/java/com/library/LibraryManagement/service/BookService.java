package com.library.LibraryManagement.service;

import com.library.LibraryManagement.entity.Book;
import com.library.LibraryManagement.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book getBook(Integer bookId) {
        return bookRepository.findById(bookId).orElse(new Book());
    }

    public Book addBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    public boolean updateBook(Book newBook) {
        Optional<Book> book = bookRepository.findById(newBook.getId());
        if(book.isPresent()) {
            Book getBook = book.get();
            getBook.setName(newBook.getName());
            getBook.setAuthor(newBook.getAuthor());
            bookRepository.save(getBook);
            return true;
        }
        return false;
    }


    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}
