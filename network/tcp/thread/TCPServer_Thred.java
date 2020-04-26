package network.tcp.thread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther Carroll
 * @Date 2020/4/20
 * @e-mail ggq_carroll@163.com
 *
 * 实现一个服务端可以同时接收多个客户端的消息。
 */
public class TCPServer_Thred {
    public static void main(String[] args) throws Exception {
        System.out.println("TCP服务端启动~~~");
        //注册端口
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true){
            //开始等待客户端的Socket管道连接
            Socket socket = serverSocket.accept();
            //每次接收到客户端发来的请求，就单独创建一个线程来处理
            new ServerReaderThred(socket).start();
        }
    }
}

class ServerReaderThred extends Thread{
    private Socket socket;
    public ServerReaderThred(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
