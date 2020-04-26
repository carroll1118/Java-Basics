package io.file;

import java.io.File;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 */
public class fileDemo {
    public static void main(String[] args) {
        File file = new File("D:\\");
        /*System.out.println(file.length());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());*/
        String[] names = file.list();
        for (String name:names){
            System.out.println(name);
        }

        File[] filed = file.listFiles();
        for (File f:filed){
            System.out.println(f);
        }
    }
}
