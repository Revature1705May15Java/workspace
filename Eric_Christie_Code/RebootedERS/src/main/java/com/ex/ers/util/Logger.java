package com.ex.ers.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
  
  private static String filename = "src/main/java/com/ex/ers/util/log.txt";
  
  static void log(String message) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
      bw.write(LocalDateTime.now() + " - " + message);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
//  @Before("execution(* com.ex..* (..))")
//  public void logMethodStart() {
//    write(LocalDateTime.now() + "\n");
//  }
//  
//
//  @After("execution(* com.ex..* (..))")
//  public void logMethodEnd() {
//    write(LocalDateTime.now() + "\n");
//  }
  
  @Around("pc()")
  public void logMethod(ProceedingJoinPoint pjp) {
    try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));) {
      log("Executing " + pjp.getSignature().getName() + " from " + pjp.getSourceLocation().getFileName() + ":"
          + pjp.getSourceLocation().getLine() /*+ " with arguments " +*/ /*pjp.getArgs()*/ + "\n");
      try {
        pjp.proceed();
      } catch (Throwable t) {
        t.printStackTrace(pw);
      }
      log("Finished execution of " + pjp.getSignature() + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
  }
  
  @Pointcut("execution(* com.ex.ers..* (..))")
  public void pc() {}
  
}
