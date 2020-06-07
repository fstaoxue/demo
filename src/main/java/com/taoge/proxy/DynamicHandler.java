package com.taoge.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicHandler  implements InvocationHandler{

    private Object handler;

    public DynamicHandler(Object handler){
        this.handler=handler;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic handler do something  start");
        return method.invoke(handler);

    }
}
