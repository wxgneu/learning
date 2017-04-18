package com.netease.spring.aop3;

import org.springframework.stereotype.Component;


@Component("nBA")
public class NBA implements Performance{

    @Override
    public int perform(int number) {
        System.out.println("yundongyuan :"+number);
        return 10;
    }
   
}
