package com.netease.spring.bean2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("dog")
public class Dog implements Animal {
    @Override
    public void eat() {
      System.out.println("dog eating..");
    }
}
