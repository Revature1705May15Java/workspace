package com.ex.aop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logs {
  
  static String filename="src/main/java/com/ex/aop/logs.txt";
  
//@Advice("Pointcut - set of locations where advice can happen")
  // Joinpoints are the places where the advice actually does happen
  @Before("execution(* com.ex.repository.MyCustomerRepository.* (..))")
  @After("execution(List<Customer> com.ex.repository.MyCustomerRepository.* (..))")
  public void logRepoMethods() {
    write(LocalDateTime.now() + " - Doing Work!\n");
  }
  
  @Around("pc()")
  public void doThing(ProceedingJoinPoint pjp) {
    System.out.println("starting method");
    try {
      pjp.proceed();
    } catch (Throwable e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("ending method");
  }
  
  @Pointcut("execution(* com.ex..* (..))")
  public void pc() {}
  
  static void write(String message) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
      bw.write(message);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
