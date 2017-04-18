package com.netease.spring.bean1.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cdPlayer")
public class CDPlayer implements MediaPlayer {
    private CompactDisc compactDisc;
    
    
    @Autowired
    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }



    @Override
    public void play() {
       compactDisc.play();
    }
}
