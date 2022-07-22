# java-based


## IO流
- 字节流
  - FileInputStream、FileOutputStream
  - BufferedInputStream、BufferedOutputStream
- 字符流
  - FilerReader、FilerWriter
  - BufferedReader、BufferedWriter
- 转换流：
  - InputStreamReader(将字节流转换为字符流)
  - OutputStreamWriter(将字符流转换为字节流)
- 打印流
  - PrintStream(字节打印流)
  - PrintWriter(字符打印流)
- 内存流：
  - ByteArrayInputStream、ByteArrayOutputStream
  - CharArrayReader、CharArrayWriter
  - StringReader、StringWriter
- 序列化流
  - ObjectInputStream、ObjectOutputStream
    
- File
- RandomAccessFile

- AIO、BIO、NIO、EPOLL

### 练习题：
- 复制文件，有几种方式? 4+
- 将文本写入文件内容,有几种方式? StringToFileDemo
- 往文件里面追加内容，有几种方式? FileAppendDemo
- 查询某个路径下，有多少个java文件?
- 将一个文件分割为两个，然后合并两个文件的内容? RandomAccessFile+SequenceInputStream

## 锁
- Synchronized
- Lock
  - ReentrantLock
- ReadWriteLock
  - ReentrantReadWriteLock
- Semaphore
- Condition
- CountDownLatch
- CyclicBarrier  
- Atomic类
- volatile关键字  

- 位运算 （加、减、乘、除、取余）
- AbstractQueuedSynchronizer
  - Sync/FairSync/NonfairSync
- CAS机制(Compare and swap)

### 练习题


## 线程
- Thread
- Runnable
- Callable
- FutureTask  
- ThreadGroup
  线程组（ThreadGroup）就是由线程组成的管理线程的类，这个类是java.lang.ThreadGroup类 每一个线程都存在相同的线程组下
- ThreadLocal
- 阻塞队列
- ThreadPool
- Executor
- Executors
- ThreadPoolExecutor

### 练习题
- wait 和 sleep有什么不同?
- stop 和 interrupt有什么不同?
- ThreadLocal作用于什么场景？为什么会造成内存泄露？如何解决?
- Collection 和 Collections是什么关系?  -> executor 和 executors是什么关系？
- 如何创建线程池?
- 线程池配置合理线程数?


## socket
- Socket、ServerSocket
- DatagramSocket、DatagramPacket
- InetAddress
  - Inet4Address
  - Inet6Address
- URL
- URLConnection
  - HttpURLConnection
- URLDecoder、URLEncoder
- TCP
- UDP

### 练习题