package com.netease.spring.aop2;

public class Knight {
    private Task task;
     
    public void setTask(Task task) {
        this.task = task;
    }
    
    public void working(){
        System.out.println("Coding balala...");
    }
    
    public int countWithExcption(){
        return 2%0;
    }
    
    public int countWithReturn(){
        return 2/1;
    }
}
