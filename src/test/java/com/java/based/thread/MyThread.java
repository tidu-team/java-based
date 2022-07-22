package com.java.based.thread;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author honglixiang@tiduyun.com
 * @date 2022/7/6
 */
public class MyThread implements Runnable{

    /**
     * 实现线程的方式 ---  继承Thread  实现Runnable
     * @param args
     */





    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
//        Thread.sleep(1); //使线程休眠不会释放锁
        thread.start();

        thread.suspend();  //挂起线程 --不会分配时间片给这个线程
        thread.resume();   //唤醒线程


//        thread.wait();  // 不会分配时间片 线程相关资源都会被释放，避免死锁
        thread.notify();
        thread.notifyAll();

        thread.stop();    // 线程不安全，线程直接杀死， 不会释放他持有的资源
        thread.interrupt();  //调用interrupt方法，线程本身还存在，只是状态改为interrupt，，


        thread.setPriority(Thread.MAX_PRIORITY); //线程优先级

        thread.setDaemon(true);  //设置守护线程 --- 守护线程的概念


    }

    @Override
    public void run() {

    }
}
