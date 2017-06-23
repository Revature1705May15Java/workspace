package com.rev.aop;

//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
//@Aspect
public class Timer {
//    @Before("pc()")
//    public void logRepoMethods() {
//        System.out.println(LocalDateTime.now() + " : Performing repo method\n");
//    }
//
//    @Around("pc()")
//    public void doThing(ProceedingJoinPoint pjp) {
//        MethodSignature sign = (MethodSignature) pjp.getSignature();
//        String methodName = sign.getName();
//
//        System.out.println(methodName + " : starting at : " + LocalDateTime.now());
//
//        try {
//            pjp.proceed();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(methodName + " : ending at : " + LocalDateTime.now());
//    }
//
//    @Pointcut("execution(* com.rev.service.CustomerServiceImpl.* (..))")
//    public void pc() {}
}
