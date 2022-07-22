### 多线程

#### 1、为什么会出现多线程、为什么需要多线程？

https://www.jianshu.com/p/5549e89133d2

**操作系统 -- 进程 -- 线程**



我们的系统在单核的时候是怎么运行的？ -- 单核 上下文切换

**何为上下文切换？**

在单核CPU时代，操作系统其实就已经能处理多线程并发任务了。处理器会给每个线程分配一个CPU时间片，线程会在获取的时间片内执行任务。



**时间片的概念是什么？**

时间片即CPU分配给各个程序的时间，每个线程被分配一个时间段，称作它的时间片，即该进程允许运行的时间，使各个程序从表面上看是同时进行的。

**为什么要使用多线程？**

这个问题也许是面试中问的最多的一个经典问题了，**一个进程里多线程之间可以共享变量，线程间通信开销也较小，可以更好的利用多核CPU的性能，多核CPU上跑多线程程序往往会比单线程更快**，有的时候甚至在单核CPU上多线程程序也会有更好的性能，**因为虽然多线程会有上下文切换和线程创建销毁开销，但是单线程程序会被IO阻塞无法充分利用CPU资源，加上线程的上下文开销较低以及线程池的大量应用，多线程在很多场景下都会有更高的效率**。



引入多核多CPU多线程的**意义**就在于 **减少上下文的切换带来的系统开销，让系统更顺畅**



#### 2、线程的底层是怎么实现的？（基础内功）

#### 3、使用多线程有哪些场景？

#### 4、我们在真正使用的时候要如何使用？（高级功法、套路）

#### 5、使用的时候要注意哪些？线程的数量？





### 问题

wait 方法和 sleep方法有什么不同？ stop和interrupt方法有什么不同？ run方法和start方法的区别 



![image-20220718171029571](C:\Users\chango\AppData\Roaming\Typora\typora-user-images\image-20220718171029571.png)





systemCode shopCode

1                      2

1                      3

4                      5

4                       6



1 -》  【2，3】

4  -》  【5，6】





### 线程池

// Array Arrays

//Collection Collections

// Executor Executors

带s的是辅助工具类





#### 线程池的7大参数

1. corePoolSize(核心线程数)：线程池中常驻线程数
2. maximumPoolSize(最大线程数):线程池中能够同时执行的最大线程数 》=1

   3.keepAliveTime(存活时间):非核心线程空闲时的存活时间

   4.unit：keepAliveTime的单位

   5.workQueue（阻塞队列）：

   6.线程工厂

   7.rejectedExecutionhandler 拒绝策略



#### 线程池的四大拒绝策略

1、abortPolicy 报错策略

2、callerRunsPolicy 调用者运行策略

3、discardOldestPolicy 抛弃等待最久任务的策略

4、discardPolicy 直接丢弃后来的任务策略



线程的生命周期 

![image-20220721140909969](C:\Users\chango\AppData\Roaming\Typora\typora-user-images\image-20220721140909969.png)





![image-20220721162909479](C:\Users\chango\AppData\Roaming\Typora\typora-user-images\image-20220721162909479.png)





SQL性能分析：



1、SQL执行频率

show global status like 'Com_______';