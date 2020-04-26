package network.rpc.server.impl;

import com.sun.org.apache.xpath.internal.SourceTree;
import network.rpc.server.Server;

import javax.sound.midi.Soundbank;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther Carroll
 * @Date 2020/4/20
 * @e-mail ggq_carroll@163.com
 */
public class ServerCenter implements Server {

    private static HashMap<String,Object> serviceRegiser = new HashMap<>();
    private static int port;// 8888
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static boolean isRunning = false;

    public ServerCenter(int port){
        this.port = port;
    }
    @Override
    public void start(){
        ServerSocket server = null;
        try {
            server = new ServerSocket();
            server.bind(new InetSocketAddress(port));
        }catch (Exception e){
            e.printStackTrace();
        }

        isRunning = true;

        while (true){
                System.out.println("sart server....");
                Socket socket = null;
                try {
                    //等待客户端连接
                    socket = server.accept();
                    executor.execute(new ServiceTask(socket));
                }catch (Exception e){
                    e.printStackTrace();
                }
        }

    }

    @Override
    public void stop() {
        isRunning = false;
        executor.shutdown();
    }

    @Override
    public void register(Class<?> service, Class serviceImpl) {
        serviceRegiser.put(service.getName(),serviceImpl);
    }


    static class ServiceTask implements Runnable{
        private Socket socket;
        public ServiceTask(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            ObjectInputStream input = null;
            ObjectOutputStream output = null;
            try {
                System.out.println("收到客户端连接请求，处理该请求---------");
                //收到客户端连接请求，处理该请求
                input = new ObjectInputStream(socket.getInputStream());
                String serviceName  = input.readUTF();
                String methodName = input.readUTF();
                Class[] parameterTypes = (Class[])input.readObject();
                Object[] arguments = (Object[])input.readObject();

                Class ServiceClass  = (Class) serviceRegiser.get(serviceName);
                Method method = ServiceClass.getMethod(methodName,parameterTypes);
                Object result = method.invoke(ServiceClass.newInstance(),arguments);
                output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(result);
            } catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    if(output != null) output.close();
                    if (input != null) input.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}

