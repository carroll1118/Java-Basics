package io.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 */
public class FileOutputStreamConstructor {
    public static void main(String[] args) throws Exception {
        File file = new File("b.txt");
        OutputStream fos = new FileOutputStream(file,true);
        /*fos.write(97); // 写出第1个字节
        fos.write(97); // 写出第1个字节
        fos.write(98); // 写出第2个字节
        fos.write(99); // 写出第3个字节*/

        byte[] bytes = "黑暗之神".getBytes();
        System.out.println(bytes.length);
        fos.write(bytes);

        fos.close();

    }
}
