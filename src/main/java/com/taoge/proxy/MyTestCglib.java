package com.taoge.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyTestCglib implements MethodInterceptor {

    private Object target;

    public Object bind(Object target){
        this.target=target;
        Enhancer enhancer=new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(this.target.getClass());
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始说了");
        method.invoke(target,objects);
        System.out.println("结束是");
        return null;
    }

    public static void main(String[] args) {
        Handler handler=(Handler) new MyTestCglib().bind(new MyHandler());
        handler.dosomething();
    }
}
