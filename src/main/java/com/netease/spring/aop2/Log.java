
package com.netease.spring.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Log {
   @Before(value="execution(* *.working(..))")
   public void before(){
       System.out.println("before ...");
   }
   
  /* @After("execution(* *.countWithReturn(..))")
   public void after(){
       System.out.println("after ...");
   }
   @AfterReturning(returning="object",pointcut="execution(* *.countWithReturn(..))")
   public void afterRetunging(Object object){
       System.out.println("afterRetunging ...");
       System.out.println(object);
   }
   */
   
   @AfterThrowing(throwing="excption",pointcut="execution(* com.netease.spring.aop2.Knight.countWithExcption(..))")
   public void afterException(Throwable excption){
       System.out.println("afterException ...");
       System.out.println(excption);
   }
   
   /*@Around("execution(* com.netease.spring.aop2.Knight.countWithReturn(..))")
   public int around(ProceedingJoinPoint joinPoint) throws Throwable{
       System.out.println("before ...");
       Object result=joinPoint.proceed();
       System.out.println("jiesu");
       System.out.println(result);
       return 3;
   }*/
}
