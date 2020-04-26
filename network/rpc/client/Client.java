package network.rpc.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Auther Carroll
 * @Date 2020/4/20
 * @e-mail ggq_carroll@163.com
 */
public class Client {
    public static <T>  T getRemoteProxyObj(Class serviceInterface, InetSocketAddress address){
        return (T)Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[]{serviceInterface}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) {

                ObjectInputStream input = null;
                ObjectOutputStream output = null;
                Socket socket = null;
                try {
                    //客户端向服务端发送请求，请求具体的某一个端口
                    socket = new Socket();
                    socket.connect(address);

                    output = new ObjectOutputStream(socket.getOutputStream()); //发送序列流
                    output.writeUTF(serviceInterface.getName());
                    output.writeUTF(method.getName());
                    output.writeObject(method.getParameterTypes());
                    output.writeObject(args);

                    //等待服务端处理...
                    input = new ObjectInputStream(socket.getInputStream());

                    return input.readObject();
                }catch (Exception e){
                    e.printStackTrace();
                    return null;
                }finally {
                    try {
                        if(output != null) output.close();
                        if (input != null) input.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
