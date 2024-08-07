package main.java.com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.java.com.library.repository.BookRepository;
import main.java.com.library.service.BookService;



public class Main {
	public static void main(String[] args) {
		 
		// loading the Bean and XML definitions from the given XML file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BookService obj1 = context.getBean(BookService.class);
		obj1.display();
		//BookRepository obj2 = context.getBean(BookRepository.class);
		obj1.findBook();
		
		context.close();
		
		
	}
}
