package com.netease.spring.aop1;

public class NBA {
    private Player player;
    
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void playNba(){
        player.play();
    }
}
