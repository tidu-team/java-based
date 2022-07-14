package com.java.based.io;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author honglixiang@tiduyun.com
 * @date 2022/7/9
 */
public class StringReaderWriterDemo {

    public static void main(String[] args) throws IOException{
        String str = "我爱你阿斯顿发生ddfafdsf /n";
//        readChar(str);
        readChars(str);
    }

    private static void readChar(String str) throws IOException {
        StringReader reader = new StringReader(str);
        StringWriter writer = new StringWriter();

        int read = 0;
        while ((read = reader.read()) !=-1){
            writer.write(read);
        }

        System.err.println(writer.toString());
    }

    private static void readChars(String str) throws IOException {
        StringReader reader = new StringReader(str);
        StringWriter writer = new StringWriter();
        int read = 0;
        char[] arr = new char[1024];
        while ((read = reader.read(arr)) !=-1){
            writer.write(arr);
        }

        System.err.println(writer.toString());
    }
}
