package com.java.based.io;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * @author honglixiang@tiduyun.com
 * @date 2022/7/14
 */
public class FileAppendDemo {

    public static void main(String[] args) throws IOException {
        String path = "append.text";
        String content = "hello world";
//        method1(path,content);
//        method2(path,content);
        method3(path,content);
    }

    public static void method1(String path,String content) throws IOException {
        FileOutputStream out = new FileOutputStream(path,true);
        out.write(content.getBytes(StandardCharsets.UTF_8));
        out.close();
    }

    public static void method2(String path,String content) throws IOException {
        FileWriter out = new FileWriter(path,true);
        out.write(content);
        out.close();
    }

    public static void method3(String path,String content) throws IOException {
        RandomAccessFile file = new RandomAccessFile(path,"rw");
        file.seek(file.length());
        file.write(content.getBytes(StandardCharsets.UTF_8));
        file.close();
    }
}
