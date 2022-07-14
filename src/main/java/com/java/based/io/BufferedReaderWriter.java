package com.java.based.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

/**
 * @author honglixiang@tiduyun.com
 * @date 2022/7/10
 */
public class BufferedReaderWriter {

    public static void main(String[] args) throws IOException{
        String from = "D:/tmp/a.MD";
        String to = "D:/tmp/d.MD";
//        readChar(from,to);
//        readChars(from,to);
//        readCharBuf(from,to);
        readLine(from,to);
    }

    private static void readChar(String from,String to) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(from));
        BufferedWriter writer = new BufferedWriter(new FileWriter(to));
        int read = 0;
        while ((read = reader.read()) != -1){
            writer.write(read);
        }
        reader.close();
        writer.close();
    }

    private static void readChars(String from,String to) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(from));
        BufferedWriter writer = new BufferedWriter(new FileWriter(to));
        int read = 0;
        char [] arr = new char[2048];
        while ((read = reader.read(arr)) != -1){
            writer.write(arr);
        }
        reader.close();
        writer.close();
    }


    private static void readCharBuf(String from,String to) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(from));
        BufferedWriter writer = new BufferedWriter(new FileWriter(to));
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

    private static void readLine(String from,String to) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(from));
        BufferedWriter writer = new BufferedWriter(new FileWriter(to));
        String s = null;
        while ((s = reader.readLine()) != null){
            writer.write(s);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }
}
