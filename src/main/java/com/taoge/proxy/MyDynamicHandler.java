package com.taoge.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDynamicHandler {

//    public static void main(String[] args) {
//        MyHandler handler=new MyHandler();
//        //consumer(handler);
//        Handler obj=(Handler) Proxy.newProxyInstance(Handler.class.getClassLoader(), new Class[]{Handler.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//                System.out.println("代理  开始");
//                Object result=method.invoke(handler,args);
//                System.out.println("代理  结束");
//                return result;
//            }
//        });
//        obj.dosomething();
//    }

    public static void main(String[] args) {
        MyHandler handler=new MyHandler();
        Handler handler1=(Handler) new TestHandler(handler).bind();
        handler1.dosomething();;
    }
}
