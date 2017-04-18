
package com.netease.spring.aop1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        NBA nba=(NBA) context.getBean("nba");
        nba.playNba();
    }
}
