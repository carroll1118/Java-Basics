package network.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther Carroll
 * @Date 2020/4/20
 * @e-mail ggq_carroll@163.com
 */
public class TCPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("TCP服务端启动~~~");
        //注册端口
        ServerSocket serverSocket = new ServerSocket(9999);
        //开始等待客户端的Socket管道连接
        Socket socket = serverSocket.accept();
        //从Socket通信管道得到一个字节输入流
        InputStream inputStream = socket.getInputStream();
        //把字节输入流转换成字符输入流
        Reader reader = new InputStreamReader(inputStream);
        //把字符输入流包装成缓冲字符输入流
        BufferedReader bufferedReader = new BufferedReader(reader);
        //按照行读消息
        String line;
        /*if ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }*/
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
    }
}
