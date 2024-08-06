package main.java.com.library;

import main.java.com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // Initializing the Spring IOC container
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService obj1 = context.getBean(BookService.class);
        obj1.run();


        //context.close();
    }
}