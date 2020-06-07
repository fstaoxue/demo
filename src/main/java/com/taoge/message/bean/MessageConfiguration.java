package com.taoge.message.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageConfiguration {

    @Bean(name = "messageSource")
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource source=new ResourceBundleMessageSource();
        return source;
    }
}
