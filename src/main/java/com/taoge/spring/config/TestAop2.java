package com.taoge.spring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class TestAop2 {

    @Pointcut("execution(public int com.taoge.spring.bean.business.*(..))")
    public void pointcut(){

    }

    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint){

    }

}
