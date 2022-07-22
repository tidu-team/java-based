package com.java.based.thread;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.omg.SendingContext.RunTime;
import sun.nio.ch.ThreadPool;

/**
 * @author chenjingyan@tiduyun.com
 * @date 2022/7/15
 */
public class MyThreadPool {
    private void pool(){
        List<Integer> objects = new ArrayList<Integer>();
        List<Integer> integers = Arrays.asList(1, 2, 3);
    }

    public static void main(String[] args) {
        // 一线程 线程池
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // 固定线程数 线程池
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // 一池处理多个线程 可自动扩容
//        ExecutorService threadPool = Executors.newCachedThreadPool();
        // 调度线程池
//        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        // 自定义线程池

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            for (int i =0; i<9 ;i++){
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 搞学习");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

        //CPU密集型： 该任务需要大量运算，线程没有阻塞情况，CPU全速运行  N+1
        //IO密集型：  该任务需要大量的IO，比如说需要疯狂的去mysql、redis拿数据，造成大量阻塞，  2N
        System.out.println("core count:" + Runtime.getRuntime().availableProcessors());


    }
}
