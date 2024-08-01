package org.example;

public class Logger {

    // 1. Private static instance
    private static Logger loggerObj;

    // 2. Private constructor
    private Logger(){}

    // 3. static getInstance() method to return instance of class
    public static Logger getInstance(){

        // 4. 2-way lock to achieve synchronization
        if(loggerObj==null){
            synchronized (Logger.class){
                if(loggerObj==null) {
                    loggerObj = new Logger();
                }
            }
        }

        return loggerObj;
    }
}
