package com.taoge.spring.bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspect {

    @Pointcut("execution(public int com.taoge.spring.bean.business.*(..))")
    public void pointCut(){
    }

    @Before("execution(public int com.taoge.spring.bean.business.*(int,int))&& args(num1,num2)")
    public void logStart(int num1,int num2){
//        System.out.println(joinPoint.getSignature().getName()+"...start");
////        System.out.println("参数"+ Arrays.asList(joinPoint.getArgs()));
        System.out.println(num1+"---"+num2);
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"...end");
    }

    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void LogReturning(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+"...return"+result);
    }

    @AfterThrowing(pointcut = "pointCut()",throwing = "e")
    public void LogException(JoinPoint joinPoint,Exception e){
        System.out.println(joinPoint.getSignature().getName()+"...exception"+e);
    }

}
