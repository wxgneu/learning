package com.netease.demo;

import java.util.Random;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = "nispTrade:name=sysMonitor", description = "trade systerm monitor")
public class  HelloMBean {
    private int count;
    private String msg;
    
    @ManagedAttribute
    public int getCount() {
        Random random=new Random();
        int value=random.nextInt(20);
        return value;
    }
    
    @ManagedAttribute
    public String getMsg() {
        return msg;
    }

    @ManagedAttribute
    public void setMsg(String msg) {
        this.msg = msg;
    }
}