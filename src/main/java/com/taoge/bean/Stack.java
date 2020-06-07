package com.taoge.bean;

public interface Stack<T> {
    T pop();

    void push(T a);

    void grow();
}
