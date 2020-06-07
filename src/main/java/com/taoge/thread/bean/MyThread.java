package com.taoge.thread.bean;

public class MyThread extends Thread {

//    public static void main(String[] args) {
//        MyObject obj=new MyObject();
//        Thread thread=new Thread(()->{
//            long sTime=System.currentTimeMillis();
//            obj.add("a");
//            long eTime=System.currentTimeMillis();
//            System.out.println(eTime-sTime);
//        });
//        thread.start();
//        Thread thread1=new Thread(()->{
//            long sTime=System.currentTimeMillis();
//            obj.addB("b");
//            long eTime=System.currentTimeMillis();
//            System.out.println(eTime-sTime);
//        });
//        thread1.start();
//    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadA=new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A");
        });
        threadA.start();
        threadA.join();
        Thread threadB=new Thread(()->{
            System.out.println("B");
        });
        threadB.start();
        Thread threadC=new Thread(()->{
            System.out.println("C");
        });
        threadC.start();
        System.out.println("hello");
    }

}
