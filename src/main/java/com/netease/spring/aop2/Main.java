
package com.netease.spring.aop2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-aop.xml");
        context.start();
        Knight knight=(Knight) context.getBean("knight");
        //knight.working();
        knight.countWithExcption();
        //knight.countWithExcption();
    }
}
