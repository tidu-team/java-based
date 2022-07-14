package com.java.based.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.CharBuffer;

/**
 * @author honglixiang@tiduyun.com
 * @date 2022/7/10
 */
public class InputStreamReaderWriterDemo {

    public static void main(String[] args) throws IOException{
        String from = "D:/tmp/a.MD";
        String to = "D:/tmp/c.MD";

//        read(from,to);
//        readChars(from,to);
        readCharBufer(from,to);
    }


    public static void read(String from ,String to) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(from));
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(to));

        int read = 0;
        while ((read = reader.read()) != -1){
            writer.write(read);
        }
        reader.close();
        writer.close();
    }

    public static void readChars(String from ,String to) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(from));
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(to));

        int read = 0;
        char[] arr = new char[1024];
        while ((read = reader.read(arr)) != -1){
            writer.write(arr);
        }
        reader.close();
        writer.close();
    }

    public static void readCharBufer(String from ,String to) throws IOException{
        InputStreamReader reader = new InputStreamReader(new FileInputStream(from));
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(to));

        CharBuffer buffer = CharBuffer.allocate(1024);
        while(true){
            buffer.clear();
             int read = reader.read(buffer);
             if(read == -1){
                 break;
             }
             buffer.flip();
             writer.write(buffer.array());
        }
        reader.close();
        writer.close();
    }
}
