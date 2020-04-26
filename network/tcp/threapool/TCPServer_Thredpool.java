package network.tcp.threapool;

import designMode.templatePattern.NewDriver;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

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
public class TCPServer_Thredpool {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("TCP服务端启动~~~");
            //注册端口
            ServerSocket serverSocket = new ServerSocket(9999);
            //一个服务端只需要对应一个线程池
            HandlerSocketThreadPool handlerSocketThreadPool =
                    new HandlerSocketThreadPool(3,100);
            while (true){
                //开始等待客户端的Socket管道连接
                Socket socket = serverSocket.accept();

                System.out.println("有人上线了");
                //每次接收到客户端发来的请求，就单独创建一个线程来处理
                handlerSocketThreadPool.execute(new ReaderClientRunnable(socket));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ReaderClientRunnable implements Runnable{
    private Socket socket;
    public ReaderClientRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //读取一行数据
            InputStream inputStream = socket.getInputStream();
            //转成一个缓冲字符流
            Reader fr = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(fr);
            //按行读取数据
            String line = null;
            while ((line = bufferedReader.readLine())!=null){
                System.out.println("服务端收到"+socket.getInetAddress()+"发来的数据："+line);
            }
        }catch (Exception e){
            System.out.println(socket.getInetAddress()+"下线了");
        }
    }
}
