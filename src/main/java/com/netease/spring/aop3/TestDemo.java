
package com.netease.spring.aop3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class)
public class TestDemo {
    @Autowired
    private Performance nBA;
    
    public void checknull(){
        Assert.assertNotNull(nBA);
    }
    
    @Test
    public void test(){
        nBA.perform(2);
    }
}
