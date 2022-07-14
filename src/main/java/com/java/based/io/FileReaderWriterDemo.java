package com.java.based.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

/**
 * @author honglixiang@tiduyun.com
 * @date 2022/7/9
 */
public class FileReaderWriterDemo {

    public static void main(String[] args)throws IOException {
        String from = "D:/tmp/a.MD";
        String to = "D:/tmp/b.MD";

        long start = System.currentTimeMillis();
//        readChar(from,to);//94
//        readChars(from,to);//32
//        readCharBuf(from,to);//32
        System.err.println(System.currentTimeMillis() -start);
    }

    private static void readChar(String from,String to) throws IOException {
        FileReader reader = new FileReader(from);
        FileWriter writer = new FileWriter(to);
        int read = 0;
        while ((read = reader.read()) != -1){
            writer.write(read);
        }
        reader.close();
        writer.close();
    }

    private static void readChars(String from,String to) throws IOException {
        FileReader reader = new FileReader(from);
        FileWriter writer = new FileWriter(to);
        int read = 0;
        char [] arr = new char[2048];
        while ((read = reader.read(arr)) != -1){
            writer.write(arr);
        }
        reader.close();
        writer.close();
    }


    private static void readCharBuf(String from,String to) throws IOException {
        FileReader reader = new FileReader(from);
        FileWriter writer = new FileWriter(to);
        CharBuffer buffer = CharBuffer.allocate(2048);
        while (true){
            buffer.clear();
            int read = reader.read(buffer);
            if(read ==-1){
                break;
            }
            buffer.flip();
            writer.write(buffer.array());
        }
        reader.close();
        writer.close();
    }
}
