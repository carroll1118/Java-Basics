package io.io;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 */
public class FRRead {
    public static void main(String[] args) throws IOException {
        Reader fr = new FileReader("read.txt");
        //System.out.println((char) fr.read());

        /*int b;
        while ((b=fr.read())!=-1){
            System.out.print((char)b);
        }*/

        int len;
        char[] cubf = new char[2];
        while (( len = fr.read(cubf))!= -1){
            System.out.println(new String(cubf,0,len));
        }
        fr.close();
    }
}
