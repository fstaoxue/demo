package com.taoge.queue;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TypeBlockingQueue implements BlockingQueue {

    private String[] data;

    private int size;

    private int capacity;

    private Lock lock=new ReentrantLock();

    private Condition isEmpty=lock.newCondition();

    private Condition isFull=lock.newCondition();

    public TypeBlockingQueue(int capacity){
        this.capacity=capacity;
        this.data=new String[capacity];
        this.size=0;
    }


    @Override
    public String take() {
        lock.lock();
        while(size==0){
            try {
                System.out.println("队列为空不能再取----");
                isEmpty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String result=data[--size];
        isFull.signalAll();
        lock.unlock();
        return result;
    }

    @Override
    public void put(String ele) {
        lock.lock();
        while(size==capacity){
            try {
                System.out.println("队列已满不能再加----");
                isFull.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data[size]=ele;
        size++;
        isEmpty.signalAll();
        lock.unlock();
    }


    public static void main(String[] args) {
        TypeBlockingQueue queue=new TypeBlockingQueue(10);
        Thread a=new Thread(new Thread09(queue));
        Thread b=new Thread(new Thread09(queue));
        Thread c=new Thread(new Thread08(queue));
        Thread d=new Thread(new Thread08(queue));
        a.start();
        b.start();
        c.start();
//        d.start();
    }
}


class Thread09 implements Runnable{


    private TypeBlockingQueue queue;

    public Thread09(TypeBlockingQueue queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        while(true){
            Random random=new Random();
            try {
                Thread.sleep(random.nextInt(10)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("已消费-->"+queue.take());
        }

    }
}

class Thread08 implements Runnable{

    private TypeBlockingQueue queue;

    public Thread08(TypeBlockingQueue queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        while(true){
            Random random=new Random();
            try {
                Thread.sleep(random.nextInt(10)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String temp=random.nextInt(1000)+"";
            queue.put(temp);
            System.out.println("已生产-->"+temp);
        }

    }
}
