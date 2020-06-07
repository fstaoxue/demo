package com.taoge.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestHandler implements InvocationHandler {

    private Handler target;

    public TestHandler(Handler target){
        this.target=target;
    }

    public Object bind(){
        return (Handler)Proxy.newProxyInstance(this.target.getClass().getClassLoader(),this.target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("kaishi  mmm");
        method.invoke(target,args);
        System.out.println("jieshud d mm");
        return null;
    }
}
