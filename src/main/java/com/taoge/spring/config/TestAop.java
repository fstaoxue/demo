package com.taoge.spring.config;

import com.taoge.spring.bean.LogAspect;
import com.taoge.spring.bean.business;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class TestAop {

    @Bean
    public business business(){
        return new business();
    }

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }

}
