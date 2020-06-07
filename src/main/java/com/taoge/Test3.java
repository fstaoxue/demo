package com.taoge;

import com.taoge.bean.Res;

public class Test3 {

    public static void main(String[] args) {
        Res res=new Res();
        ThreadA a=new ThreadA(res);
        ThreadB b=new ThreadB(res);
        a.start();
        b.start();

    }
}

class ThreadA extends Thread{
    private Res res;
    public ThreadA(Res res){
        this.res=res;
    }

    @Override
    public void run() {
        int count=0;
        while(true){
            synchronized (res){
                if(res.flag){
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(count==0){
                    res.name="男";
                    res.sex="1";
                }else if(count==1){
                    res.name="女";
                    res.sex="2";
                }
                count=(count+1)%2;
                res.flag=true;
                res.notify();
            }
        }

    }
}

class ThreadB extends Thread{
    private Res res;
    public ThreadB(Res res){
        this.res=res;
    }

    @Override
    public void run() {
        while(true){
            synchronized (res){
                if(!res.flag){
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.name+","+res.sex);
                res.flag=false;
                res.notify();
            }
        }

    }
}
