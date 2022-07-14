package com.java.based.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author honglixiang@tiduyun.com
 * @date 2022/7/14
 */
public class ByteArrayInputOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        String str = "hello world";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        out.write(bytes,0,bytes.length);
        out.close();
        System.err.println(out.toString());

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
         int read = 0;
         while ((read = in.read()) != -1){
             System.err.print((char) read);
         }
    }




}
