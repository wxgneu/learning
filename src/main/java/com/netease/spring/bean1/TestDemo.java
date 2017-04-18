package com.netease.spring.bean1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CompontConfig.class)
public class TestDemo {
   @Autowired
   private CompactDisc compactDisc;
   
   @Autowired 
   private MediaPlayer mediaPlayer;
   
   @Test
   public void testEst(){
       Assert.assertNotNull(compactDisc);
   }
   
   @Test
   public void testPlay(){
       mediaPlayer.play();
   }
}
