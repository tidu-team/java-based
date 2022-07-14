package com.java.based.io;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * @author honglixiang@tiduyun.com
 * @date 2022/7/14
 */
public class CharArrayReaderWriterDemo {

    public static void main(String[] args) throws IOException {
        String str = "hello world";
        CharArrayReader reader = new CharArrayReader(str.toCharArray());

        CharArrayWriter writer = new CharArrayWriter();
        int read = 0;
        while ((read= reader.read()) != -1){
            writer.write(read);
        }

        System.err.println(writer.toString());
    }
}
