package main.java.com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public BookRepository() {
    }

    public void run(){
        System.out.println("repository is running...");
    }
}
