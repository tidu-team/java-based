package com.java.based.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sun.nio.ch.ThreadPool;

/**
 * @author chenjingyan@tiduyun.com
 * @date 2022/7/18
 */
public class MyExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute( () -> {
            System.out.println(Thread.currentThread().getName());
        });
    }
}
