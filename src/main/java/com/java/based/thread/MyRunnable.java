package com.java.based.thread;

/**
 * @author chenjingyan@tiduyun.com
 * @date 2022/7/15
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        thread1.setName("thread1");
        thread1.start();
    }
}
