package com.java.based.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.util.NumberUtils;

/**
 * @author chenjingyan@tiduyun.com
 * @date 2022/7/18
 */
public class MyThreadLocal {
    /**
     * ThreadLocal是什么？
     * ThreadLocal是一个将在多线程中为每一个线程创建单独的变量副本的类;
     * 当使用ThreadLocal来维护变量时, ThreadLocal会为每个线程创建单独的变量副本, 避免因多线程操作共享变量而导致的数据不一致的情况;
     * 应用场景:  ---  解决数据库连接、Session管理等
     */

    public static class MyRunnable implements Runnable {
        /**
         * 例化了一个ThreadLocal对象。我们只需要实例化对象一次，并且也不需要知道它是被哪个线程实例化。
         * 虽然所有的线程都能访问到这个ThreadLocal实例，但是每个线程却只能访问到自己通过调用ThreadLocal的
         * set()方法设置的值。即使是两个不同的线程在同一个ThreadLocal对象上设置了不同的值，
         * 他们仍然无法访问到对方的值。
         */
        private ThreadLocal<List<Integer>> threadLocal = new ThreadLocal();

        private List<Integer> variableList = new ArrayList<>();

        @Override
        public void run() {
            //一旦创建了一个ThreadLocal变量，你可以通过如下代码设置某个需要保存的值
            ArrayList<Integer> arrayList = new ArrayList<>();
            int value = (int) (Math.random() * 100D);
            arrayList.add(value);
            threadLocal.set(arrayList);
            variableList.add(value);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            //可以通过下面方法读取保存在ThreadLocal变量中的值
            System.out.println("-------threadLocal value-------"+threadLocal.get().get(0));
            System.out.println("-------variableList value-------"+variableList);
        }
    }
    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();
    }
}
