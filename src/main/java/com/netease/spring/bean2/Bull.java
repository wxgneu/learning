package com.netease.spring.bean2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bull")
public class Bull implements Animal {

    @Override
    public void eat() {
        System.out.println("bull eating...");
    }
}
