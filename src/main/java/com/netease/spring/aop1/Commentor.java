package com.netease.spring.aop1;

public class Commentor {
    public void beforeGame(){
        System.out.println("game begin");
    }
    
    public void afterGame(){
        System.out.println("game end");
    }
}
