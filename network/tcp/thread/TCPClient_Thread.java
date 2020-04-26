package network.tcp.thread;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Auther Carroll
 * @Date 2020/4/20
 * @e-mail ggq_carroll@163.com
 */
public class TCPClient_Thread {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动成功~~~");
        //客户端要请求与服务端的scoket管道连接
        Socket socket = new Socket("127.0.0.1",9999);
        //从socket通信管道中得到一个字节输出流
        OutputStream outputStream = socket.getOutputStream();
        //低级的字节输出流包装成高级的打印流
        PrintStream printStream = new PrintStream(outputStream);
        //开始发送消息出去
        //printStream.println("我是TCP客户端，喜欢你很久了，第一次给你发消息，今晚一起吃个饭?");  //单次发送
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入：");
            printStream.println(sc.nextLine());
            printStream.flush();
            System.out.println("客户端本次发送完毕~~~");
        }
    }
}
