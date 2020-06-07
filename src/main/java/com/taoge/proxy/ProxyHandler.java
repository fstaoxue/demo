package com.taoge.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler {

    private Handler handler;

    public ProxyHandler(Handler handler){
        this.handler=handler;
    }

    public void dosomething(){
        System.out.println("proxy do something start");
        handler.dosomething();
        System.out.println("proxy do something end");
    }

    public static void main(String[] args) {
        Handler handler=new MyHandler();
        ProxyHandler proxyHandler=new ProxyHandler(handler);
        proxyHandler.dosomething();
    }
}
