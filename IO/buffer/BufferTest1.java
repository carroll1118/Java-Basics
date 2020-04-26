package io.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 */
public class BufferTest1 {
    public static void main(String[] args) throws Exception {
        BufferedReader fis = new BufferedReader(new FileReader("csb1"));

        List<String> list = new ArrayList<>();
        String line = null;
        while ((line = fis.readLine())!=null){
            list.add(line);
            //System.out.println(line);
        }
        List<Character> sizes = new ArrayList<>();
        Collections.addAll(sizes,'零','一','二','三','四','五','六','七','八','九','十');

        Collections.sort(list, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               return sizes.indexOf(o1.charAt(0)) - sizes.indexOf(o2.charAt(0));
           }
       });

        Collections.sort(list, (o1, o2)-> sizes.indexOf(o1.charAt(0)) - sizes.indexOf(o2.charAt(0)));


        BufferedWriter fos = new BufferedWriter(new FileWriter("newcsb1"));
        for (String list1:list){
           fos.write(list1);
           fos.write("\t\n");
        }


        fos.close();
        fis.close();
    }
}
