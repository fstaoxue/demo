package com.taoge;

import com.taoge.bean.Res;

public class Test4 {

    public static void main(String[] args) {
        Res res = new Res();
        ThreadC c = new ThreadC(res);
        ThreadD d = new ThreadD(res);
        c.start();
        d.start();

    }
}

class ThreadC extends Thread {
    private Res res;

    public ThreadC(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            res.lock.lock();
            if (res.flag) {
                try {
                    res.condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (count == 0) {
                res.name = "男";
                res.sex = "1";
            } else if (count == 1) {
                res.name = "女";
                res.sex = "2";
            }
            count = (count + 1) % 2;
            res.flag = true;
            res.condition.signal();
            res.lock.unlock();
        }

    }
}

class ThreadD extends Thread {
    private Res res;

    public ThreadD(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            res.lock.lock();
            if (!res.flag) {
                try {
                    res.condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(res.name + "," + res.sex);
            res.flag = false;
            res.condition.signal();
            res.lock.unlock();
        }

    }
}
