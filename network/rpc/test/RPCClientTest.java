package network.rpc.test;

import network.rpc.client.Client;
import network.rpc.server.HelloService;
import network.rpc.server.WorldService;

import java.net.InetSocketAddress;

/**
 * @Auther Carroll
 * @Date 2020/4/20
 * @e-mail ggq_carroll@163.com
 */
public class RPCClientTest {
    public static void main(String[] args) throws ClassNotFoundException {
        HelloService service1 = Client.getRemoteProxyObj(Class.forName("network.rpc.server.HelloService"),new InetSocketAddress("127.0.0.1",8888));
        System.out.println(service1.sayHi("Carroll"));
    }
}
