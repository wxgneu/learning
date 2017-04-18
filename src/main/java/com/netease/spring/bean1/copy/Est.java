package com.netease.spring.bean1.copy;

import org.springframework.stereotype.Component;

@Component(value="gantexi")
public class Est implements CompactDisc {
    private String name="fantexi";
    private String art="zhoujilun";
    @Override
    public void play() {
      System.out.println("ART: "+art+" paly NAME: "+name);
    }
}
