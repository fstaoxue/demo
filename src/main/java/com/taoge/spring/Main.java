package com.taoge.spring;

import com.taoge.spring.bean.business;
import com.taoge.spring.config.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] names=context.getBeanDefinitionNames();
        for(String name:names){
            System.out.println(name);
        }
        business business=context.getBean(business.class);
        business.divide(5,0);
    }


}


