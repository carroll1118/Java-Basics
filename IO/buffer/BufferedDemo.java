package io.buffer;

import java.io.*;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 *
 * 缓冲流,也叫高效流，是对4个基本的`FileXxx` 流的增强
 *
 * 字节缓冲流：BufferedInputStream，BufferedOutputStream
 * 字符缓冲流：BufferedReader，BufferedWriter
 */
public class BufferedDemo {
    public static void main(String[] args) throws Exception {
        // 创建字节缓冲输入流
        /*BufferedInputStream bis = new BufferedInputStream(new FileInputStream("writer.txt"));
        int len;
        byte[] res = new byte[1024];
        while ((len = bis.read(res))!=-1){
            System.out.println(new String(res,0,len));
        }
        bis.close();*/

        // 创建字节缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("writer.txt"));
        bos.write(66);

        bos.close();
    }
}
