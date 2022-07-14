package com.java.based.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * InputStream
 *  FileInputStream
 *  BufferedInputStream
 *  ByteArrayInputStream
 *  ObjectInputStream
 *
 * OutputStream
 *  FileOutputStream
 *  BufferedOutputStream
 *  ByteArrayOutputStream
 *  ObjectOutputStream
 *
 * OutputStreamWriter
 * InputStreamReader
 *
 * Reader
 *  FilerReader
 *  BufferedReader
 *  CharArrayReader
 *  StringReader
 *
 * Writer
 *  FilerWriter
 *  BufferedWriter
 *  CharArrayWriter
 *  StringWriter
 *
 *  PrintStream
 *  PrintWriter
 *
 *  1.读取文件内容
 *  2.复制文件
 *  3.将文本写入文件内容,有几种方式
 *  4.往文件里面追加内容，有几种方式
 *
 * @author honglixiang@tiduyun.com
 * @date 2022/7/6
 */
public class InputStreamExample {

    private void fileInputStream() throws IOException {
         FileInputStream inputStream = new FileInputStream("D:/笔记资料/netty");

    }
}
