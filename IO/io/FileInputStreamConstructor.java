package io.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 */
public class FileInputStreamConstructor {
    public static void main(String[] args) throws Exception {
        File file = new File("b.txt");
        InputStream fos = new FileInputStream(file);
        /*System.out.println((char) fos.read());*/

        /*循环改进读取方式*/

        /*int b;
        while ((b=fos.read())!=-1){
            System.out.println((char)b);
        }*/

        /*使用字节数组读取*/
        int len;
        byte[] b = new byte[2];
        while ((len=fos.read(b))!=-1){
            System.out.println(new String(b));
        }


        fos.close();
    }
}
