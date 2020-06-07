package com.taoge.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class business {

    public int divide(int i,int m){
        return i/m;
    }

    public int add(int i,int m){
        return i+m;
    }
}
