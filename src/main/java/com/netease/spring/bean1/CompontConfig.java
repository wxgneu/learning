package com.netease.spring.bean1;

import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages="com.netease.spring.bean")
public class CompontConfig {
   @Bean
    public CompactDisc est(){
       return new Est();
   }
   
   @Bean
   public MediaPlayer cdPlayer(CompactDisc compactDisc){
       return new CDPlayer(compactDisc);
   }
}
