package com.taoge.bean;

public interface List2<T> {

    void push(T a);

    void get(int index);

    void size();

    void clear();

    boolean contains(T a);
}
