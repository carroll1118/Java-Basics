package io.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 */
public class FOSWrite {
    public static void main(String[] args) throws Exception {
        OutputStream fos = new FileOutputStream("b.txt",true);
        byte[] bytes = {97,98,99,100,101,102};
        for (byte bye:bytes){
            fos.write(bye);
            fos.write("\r\n".getBytes());
        }
        //关闭资源
        fos.close();
    }
}
