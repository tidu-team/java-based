package com.java.based.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author chenjingyan@tiduyun.com
 * @date 2022/7/18
 */
public class MyCallable {
     /**
     *            Runnable 和 Callable区别
     * Runnable没有返回值；Callable可以返回执行结果（泛型）。
     * Runnable异常只能在内部处理，不能往上继续抛出；Callable接口的call()方法允许抛出异常。
     * Callable需要配合FutureTask或Future使用
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        new Thread(new RunnableDemo1(),"AA").start();

        FutureTask<Integer> futureTask = new FutureTask<>(new CallableDemo<Integer>());
        new Thread(futureTask,"BB").start();
        // 通过isDone判断是否已完成
        System.out.println("是否已完成：" + futureTask.isDone());
        // 在线程执行完后，我们可以通过futureTask的get方法来获取到返回的值。
        Thread.sleep(1000);

        System.out.println("返回值：" + futureTask.get());

        System.out.println("是否已完成：" + futureTask.isDone());
//        System.out.println("在获取结果时，给定一个等待时间，如果超过等待时间还未获取到结果，则会主动抛出超时异常::"+futureTask.get(2, TimeUnit.SECONDS));

    }
}
class RunnableDemo1 implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"::通过实现Runnable来执行任务");
    }
}
class CallableDemo<Integer> implements Callable<java.lang.Integer> {

    @Override
    public java.lang.Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"::通过实现Callable接口来执行任务，并返回结果！");
        int value = 0;
        for (int i=0;i<30;i++){
            value += i;
            Thread.sleep(100);
        }
        return 1024;
    }

    /**
     * 应用场景：
     *
     * 在主线程执行那种比较耗时的操作时，但同时又不能去阻塞主线程时，就可以将这样的任务交给FutureTask对象在后台完成，然后等之后主线程需要的时候，就可以直接get()来获得返回数据或者通过isDone（）来获得任务的状态。
     * 一般FutureTask多应用于耗时的计算，这样主线程就可以把一个耗时的任务交给FutureTask，然后等到完成自己的任务后，再去获取计算结果
     *
     * 注意：
     *
     * 仅在计算完成时才能检索结果；如果计算尚未完成，则阻塞 get 方法。
     * 一旦计 算完成，就不能再重新开始或取消计算。
     * get 方法而获取结果只有在计算完成时获取，否则会一直阻塞直到任务转入完成状态，然后会返回结果或者抛出异常。
     * 因为只会计算一次,因此通常get方法放到最后。
     *
     */
}

