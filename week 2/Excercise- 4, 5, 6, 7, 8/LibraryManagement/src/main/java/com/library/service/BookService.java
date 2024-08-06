package main.java.com.library.service;

import main.java.com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
    public void setRepository(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public void run(){
        System.out.println("service is working...");
        //bookRepository.run();
    }
}
