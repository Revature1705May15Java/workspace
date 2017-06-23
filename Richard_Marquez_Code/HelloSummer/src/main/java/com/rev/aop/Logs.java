package com.rev.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDateTime;

//@Component
//@Aspect
public class Logs {
    static String filename = "logs.txt";

    static void write(String message) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {

            bw.write(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Before("pc()")
    public void logRepoMethods() {
        write(LocalDateTime.now() + " : Performing repo method\n");
    }

//    @Around("pc()")
//    public void doThing(ProceedingJoinPoint pjp) {
//        System.out.println("starting methdo");
//        MethodSignature sign = (MethodSignature) pjp.getSignature();
//        String[] paramNames = sign.getParameterNames();
//
//        String msg = "";
//        for (String p : paramNames) {
//            msg += p;
//        }
//        System.out.println(msg);
//
//        try {
//            pjp.proceed();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("ending method");
//    }

//    @After("execution(String com.rev.repository.CustomerRepositoryImpl.* (..))")
    public void logRepoStrMethods() {
        write(LocalDateTime.now() + " : Performing repo STRING method\n");
    }

//    @Pointcut("execution(* com.rev..* (..))")
    public void pc() {}
}
