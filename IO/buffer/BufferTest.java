package io.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 */
public class BufferTest {
    public static void main(String[] args) throws Exception {
        BufferedReader fis = new BufferedReader(new FileReader("csb"));

        List<String> list = new ArrayList<>();
        String line = null;
        while ((line = fis.readLine())!=null){
            list.add(line);
            //System.out.println(line);
        }
        Collections.sort(list);
        BufferedWriter fos = new BufferedWriter(new FileWriter("newcsb"));
        for (String list1:list){
           fos.write(list1);
           fos.write("\t\n");
        }


        fos.close();
        fis.close();
    }
}
