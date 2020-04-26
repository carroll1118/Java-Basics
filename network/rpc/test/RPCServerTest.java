package network.rpc.test;

import network.rpc.server.HelloService;
import network.rpc.server.impl.HelloServiceImpl;
import network.rpc.server.Server;
import network.rpc.server.impl.ServerCenter;

/**
 * @Auther Carroll
 * @Date 2020/4/20
 * @e-mail ggq_carroll@163.com
 */
public class RPCServerTest {
    public static void main(String[] args) throws Exception {
        Server server = new ServerCenter(8888);
        server.register(HelloService.class, HelloServiceImpl.class);
        server.start();
    }
}
