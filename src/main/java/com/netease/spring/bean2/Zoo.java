package com.netease.spring.bean2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Zoo {
    @Autowired
    @Qualifier("pig")
    private Animal animal;
}
