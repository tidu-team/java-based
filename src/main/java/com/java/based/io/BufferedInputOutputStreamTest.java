package com.java.based.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author honglixiang@tiduyun.com
 * @date 2022/7/9
 */
public class BufferedInputOutputStreamTest {

    public static void main(String[] args) throws IOException {
        String from = "D:/cmp-maintenance-server_3.1.0.tar.gz";
        String to ="D:/tmp/cmp-maintenance-server_3.1.0.tar.gz";
        long start = System.currentTimeMillis();
        read(from,to);
//        read2(from,to);
        System.err.println(System.currentTimeMillis() -start);
    }


    /**
     * 1005
     * @param fromPath
     * @param toPath
     * @throws IOException
     */
    private static void read(String fromPath,String toPath) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(fromPath));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(toPath));
        int read = 0;
        byte[] arr = new byte[2048];
        while ((read = in.read(arr)) != -1){
            out.write(arr);
        }
        in.close();
        out.close();
    }


    /**
     * 988
     * @param fromPath
     * @param toPath
     * @throws IOException
     */
    private static void read2(String fromPath,String toPath) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(fromPath));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(toPath));
        int read = 0;
        byte[] arr = new byte[2048];
        while ((read = in.read(arr,0,arr.length)) != -1){
            out.write(arr);
        }
        in.close();
        out.close();
    }
}
