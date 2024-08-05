package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
	
	private BookRepository bookRepository;

    // Setter method for BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public void findBook() {
    	bookRepository.getBook();
    }
	public void display() {
		System.out.println("From Book service");
	}
}
