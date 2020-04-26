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
public class RPCClientTest2 {
    public static void main(String[] args) throws ClassNotFoundException {
        WorldService service2 = Client.getRemoteProxyObj(Class.forName("network.rpc.server.WorldService"),new InetSocketAddress("127.0.0.1",8888));
        System.out.println(service2.see("kongkong"));
    }
}
