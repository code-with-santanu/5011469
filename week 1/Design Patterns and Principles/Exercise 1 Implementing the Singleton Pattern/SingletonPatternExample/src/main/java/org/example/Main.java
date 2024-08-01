package org.example;

public class Main {
    public static void main(String[] args) {
        // Get the only object available
        Logger logger1 = Logger.getInstance();
        System.out.println("The first instance: "+ logger1);
        Logger logger2 = Logger.getInstance();
        System.out.println("The second instance: "+ logger2);


        // Verify that both logger1 and logger2 point to the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }
    }
}