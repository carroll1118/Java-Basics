package io.io;

import java.io.*;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 *
 * 流的关闭原则：先开后关，后开先关。
 */
public class Copy {
    public static void main(String[] args) throws IOException {
        //输入流
        InputStream fis = new FileInputStream("D:\\profile.jpg");

        OutputStream fos = new FileOutputStream("a.jpg");

        byte[] b = new byte[1024];
        int len;
        while ((len=fis.read(b))!=-1){
            fos.write(b,0,len);
        }

        fos.close();
        fis.close();
    }
}
