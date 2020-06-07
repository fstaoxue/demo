package com.taoge.bean;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> implements Stack<T> {

    private Object[] data;

    private int capacity;

    private int index;

    private final static int INIT_CAPACITY=10;

    public MyStack(){
        data=new Object[INIT_CAPACITY];
        capacity=INIT_CAPACITY;
        index=0;
    }

    @Override
    public T pop() {
        if(index>0){
            return (T)data[--index];
        }
        throw  new EmptyStackException();
    }

    @Override
    public void push(T a) {
        grow();
        data[index++]=a;
    }

    @Override
    public void grow() {
        if((index+1)>=capacity){
            capacity=capacity*2;
            data= Arrays.copyOf(data,capacity);
        }
    }
}
