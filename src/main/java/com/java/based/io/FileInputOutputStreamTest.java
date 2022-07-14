package com.java.based.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author honglixiang@tiduyun.com
 * @date 2022/7/9
 */
public class FileInputOutputStreamTest {

    public static void main(String[] args) throws IOException {
        String from = "D:/cmp-maintenance-server_3.1.0.tar.gz";
        String to = "D:/tmp/cmp-maintenance-server_3.1.0.tar.gz";
        long start = System.currentTimeMillis();
//        readTest(from,to);
//        readBytesTest(from,to);
//        channelReadByteBuffer(from,to);
//        channelTransferTo(from,to);
        System.err.println(System.currentTimeMillis() -start);
    }

    /**
     * read() 每次读一个字节
     * @param fromPath
     * @param toPath
     * @throws IOException
     */
    private static void readTest(String fromPath,String toPath) throws IOException {
        FileInputStream inputStream = new FileInputStream(fromPath);
        FileOutputStream outputStream = new FileOutputStream(toPath);
        int read = 0;
        while ((read = inputStream.read()) != -1){
            outputStream.write(read);
        }
        inputStream.close();
        outputStream.close();
    }

    /**
     * read(byte[]) 每次读一个字节数组 2518
     * @param fromPath
     * @param toPath
     * @throws IOException
     */
    private static void readBytesTest(String fromPath,String toPath) throws IOException {
        FileInputStream in = new FileInputStream(fromPath);
        FileOutputStream out = new FileOutputStream(toPath);
        byte[] arr = new byte[2048];
        int read = 0;
        while ((read = in.read(arr)) !=-1){
            out.write(arr);
        }
        in.close();
        out.close();
    }

    /**
     * 通过文件管道read(ByteBuffer) 1948
     * @param fromPath
     * @param toPath
     * @throws IOException
     */
    private static void channelReadByteBuffer(String fromPath,String toPath) throws IOException {
        FileChannel inChannel = new FileInputStream(fromPath).getChannel();
        FileChannel outChannel = new FileOutputStream(toPath).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(10240);
        while (true) {
            buffer.clear();
            int read = inChannel.read(buffer);
            if(read == -1){
                break;
            }
            buffer.flip();
            outChannel.write(buffer);
        }
        inChannel.close();
        outChannel.close();
    }

//    private static void channelReadByteBuffers(String fromPath,String toPath) throws IOException {
//        FileChannel inChannel = new FileInputStream(fromPath).getChannel();
//        FileChannel outChannel = new FileOutputStream(toPath).getChannel();
//
//        ByteBuffer buffer1 = ByteBuffer.allocate(10240);
//        ByteBuffer buffer2 = ByteBuffer.allocate(10240);
//        ByteBuffer[] buffers = new ByteBuffer[]{buffer1,buffer2};
//        long read = 0 ;
//        while ((read = inChannel.read(buffers)) !=-1) {
//            outChannel.write(buffers);
//        }
//        inChannel.close();
//        outChannel.close();
//    }

    /**
     * 将此通道的文件中的字节传输到给定的可写字节通道。尝试读取从该通道文件中给定位置开始的 count 个字节，并将它们写入目标通道。此方法的调用可能会也可能不会传输所有请求的字节；
     *
     * 是否这样做取决于通道的性质和状态。如果此通道的文件从给定位置开始包含少于 count 个字节，或者如果目标通道是非阻塞的并且其输出缓冲区中的空闲字节少于 count 个，则传输的字节数少于请求的字节数。
     *
     * 此方法不会修改此通道的位置。如果给定位置大于文件的当前大小，则不传输任何字节。如果目标通道有一个位置，则从该位置开始写入字节，然后该位置增加写入的字节数。这种方法可能比从该通道读取并写入目标通道的简单循环更有效。
     *
     * 许多操作系统可以直接将字节从文件系统缓存传输到目标通道，而无需实际复制它们。
     *
     * 359
     * @param fromPath
     * @param toPath
     * @throws IOException
     */
    private static void channelTransferTo(String fromPath,String toPath) throws IOException {
        FileChannel inChannel = new FileInputStream(fromPath).getChannel();
        FileChannel outChannel = new FileOutputStream(toPath).getChannel();

        long size = inChannel.size();
        long count = size;
        while (count  > 0){
            long result = inChannel.transferTo((size - count), count, outChannel);
            count = count - result;
        }
        inChannel.close();
        outChannel.close();
    }
}
