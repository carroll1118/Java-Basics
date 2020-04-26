package network.rpc.server.impl;

import network.rpc.server.HelloService;

/**
 * @Auther Carroll
 * @Date 2020/4/20
 * @e-mail ggq_carroll@163.com
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHi(String name) {
       return "hi,"+name;
    }
}
