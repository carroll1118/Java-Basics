package network.rpc.server;

import java.io.IOException;

/**
 * @Auther Carroll
 * @Date 2020/4/20
 * @e-mail ggq_carroll@163.com
 */
public interface Server {
    public void start();
    public void stop();
    //注册服务
    public void register(Class<?> service,Class serviceImpl);
}
