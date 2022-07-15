package com.java.based.io;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author honglixiang@tiduyun.com
 * @date 2022/7/14
 */
public class StringToFileDemo {

    private volatile String name;

    public static void main(String[] args) throws IOException{
        String file = "strTo.text";
        String s ="132 456789";
//        method(file,s);
//        method2(file,s);
//        method3(file,s);
//        method4(file,s);
        method5(file,s);
    }


    public static void method(String file,String context) throws IOException {
        FileOutputStream out = new FileOutputStream(file);
        out.write(context.getBytes(StandardCharsets.UTF_8));
        out.close();
    }

    public static void method2(String file,String context) throws IOException {
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        out.write(context.getBytes(StandardCharsets.UTF_8));
        out.close();
    }

    public static void method3(String file,String context) throws IOException {
        FileWriter out = new FileWriter(file);
        out.write(context);
        out.close();
    }

    public static void method4(String file,String context) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write(context);
        out.close();
    }

    public static void method5(String file,String context) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file));
        out.write(context);
        out.close();
    }
}
