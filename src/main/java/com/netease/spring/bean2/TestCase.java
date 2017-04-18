package com.netease.spring.bean2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ZooConfig.class)
public class TestCase {
    @Autowired
    private Zoo zoo;
    
    @Autowired
    @Qualifier("pig")
    private Animal animal;
    
    @Autowired
    @Qualifier("pig")
    private Animal animal1;
    
    @Test
    public void testInjection(){
        Assert.assertNotNull(zoo);
    }
    
    @Test
    public void test(){
        Assert.assertEquals(animal1, animal);;
    }
}
