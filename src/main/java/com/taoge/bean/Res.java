package com.taoge.bean;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Res {

    public String sex;

    public String name;

    public boolean flag = false;

    public Lock lock = new ReentrantLock();

    public Condition condition=lock.newCondition();
}
