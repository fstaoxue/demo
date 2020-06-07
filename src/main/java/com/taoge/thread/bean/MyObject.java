package com.taoge.thread.bean;

public class MyObject {

    private int num=0;

    public synchronized void  add(String name){
        if("a".equals(name)){
            num=100;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if("b".equals(name)){
            num=1000;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+"num="+num);
    }

    public synchronized void addB(String name){
        if("a".equals(name)){
            num=200;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if("b".equals(name)){
            num=2000;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+"num="+num);
    }
}
