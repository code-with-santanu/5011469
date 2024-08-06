package main.java.com.library.service;

import main.java.com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    private String message;

    public void setRepository(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public BookService(String msg) {
        this.message = msg;
    }

    public void run(){
        System.out.println(this.message);
        bookRepository.run();
    }
}
