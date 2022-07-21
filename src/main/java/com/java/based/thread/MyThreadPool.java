package com.java.based.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import sun.nio.ch.ThreadPool;

/**
 * @author chenjingyan@tiduyun.com
 * @date 2022/7/15
 */
public class MyThreadPool {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute( () -> {
            System.out.println(Thread.currentThread().getName());
        });
    }
}
