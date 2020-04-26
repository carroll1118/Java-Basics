package network.rpc.server.impl;

import network.rpc.server.WorldService;

/**
 * @Auther Carroll
 * @Date 2020/4/24
 * @e-mail ggq_carroll@163.com
 */
public class WorldServiceImpl implements WorldService {
    @Override
    public String see(String name) {
        return name + "会唱，跳，Rap.还会打篮球...你会吗？";
    }
}
