package com.java.based.io;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author honglixiang@tiduyun.com
 * @date 2022/7/12
 */
public class PrintDemo {

    public static void main(String[] args) throws IOException{
        String to = "print.text";
//        printStream(to);
        printWriter(to);
    }


    /**
     * print()
     * println() = print() + newLine()
     * write()
     * append()
     * format()/printf()
     * @param to
     * @throws IOException
     */
    private static void printStream(String to) throws IOException {
        PrintStream print = new PrintStream(new FileOutputStream(to),true);
        print.print(100);
        print.print("打分");
        print.print(true);
        print.println(100);
        print.println("打分");
        print.println(true);
        print.format("id:%d,name:%s",123,"张三");
        print.append("append");
        print.append("holle world",1,5);
        print.close();
    }

    /**
     * print()
     * println() = print() + newLine()
     * write()
     * append()
     * format()/printf()
     * @param to
     * @throws IOException
     */
    private static void printWriter(String to) throws IOException{
        PrintWriter writer = new PrintWriter(new FileWriter(to));
        writer.println("fsda");
        writer.println(false);
        writer.println(100);
        writer.append("123");
        writer.append("fasdf");
        writer.format("id:%d,name:%s",123,"张三");
        writer.close();
    }
}
