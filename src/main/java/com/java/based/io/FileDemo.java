package com.java.based.io;

import java.io.File;
import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * @author honglixiang@tiduyun.com
 * @date 2022/7/20
 */
@Slf4j
public class FileDemo {

    public static void main(String[] args) {
        File file = new File("D:\\Tidu\\gitbub-projects");
        log.info("totalSpace : {}",file.getTotalSpace());
        log.info("length : {}",file.length());
        log.info("path : {}",file.getPath());
        log.info("absolutePath : {}",file.getAbsolutePath());
        Arrays.stream(file.listFiles()).forEach(v -> {
            log.info("name : {} , isDirectory : {} , isFile : {}",v.getName(),v.isDirectory(),v.isFile());
        });
    }
}
