package io.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 */
public class FWWrite {
    public static void main(String[] args) throws IOException {
        Writer fw = new FileWriter("writer.txt");
        /*fw.write(97);

        // 字符串转换为字节数组
        char[] chars = "黑马程序员".toCharArray();

        // 写出字符数组
        fw.write(chars); // 黑马程序员

        // 写出从索引2开始，2个字节。索引2是'程'，两个字节，也就是'程序'。
        fw.write(chars,2,2); // 程序*/

        String msg = "阿苏部分";
        fw.write(msg);

        fw.flush();//刷新缓冲区，流对象可以继续使用。
        /*【注意】关闭资源时,与FileOutputStream不同。
      	 如果不关闭,数据只是保存到缓冲区，并未保存到文件。*/
        fw.close();
    }
}
