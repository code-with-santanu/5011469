package main.java.com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.library.*.*(..))")
    public void logBefore() {
        System.out.println("Method execution started");
    }

    @After("execution(* com.example.library.*.*(..))")
    public void logAfter() {
        System.out.println("Method execution finished");
    }

}
