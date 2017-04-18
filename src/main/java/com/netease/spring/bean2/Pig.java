package com.netease.spring.bean2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pig")
@Scope(scopeName="prototype")
public class Pig implements Animal {
    @Override
    public void eat() {
       System.out.println("pig eating...");
    }
}
