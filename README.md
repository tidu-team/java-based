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

### 练习题：
- 复制文件，有几种方式
- 将文本写入文件内容,有几种方式
- 往文件里面追加内容，有几种方式


## 锁
- Synchronized
- Lock
  - ReentrantLock
- ReadWriteLock
  - ReentrantReadWriteLock
- Condition
- CountDownLatch
- CyclicBarrier  
- AbstractQueuedSynchronizer
- Semaphore
  
- Atomic类
- volatile关键字  
- CAS机制(Compare and swap)

### 练习题


## 线程
- Thread
- Runnable
- Callable
- FutureTask  
- ThreadGroup
- ThreadLocal
- ThreadPool
- Executor
- Executors

### 练习题


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