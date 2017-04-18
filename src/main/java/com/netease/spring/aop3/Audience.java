package com.netease.spring.aop3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {
   @Pointcut("execution(* *.perform(int))") 
   public void ad(int number){
       
   }
   
   @Around("ad()")
   public void watch(ProceedingJoinPoint joinPoint) throws Throwable{
       System.out.println("before ...");
       joinPoint.proceed();
       System.out.println("after...");
   }
}
