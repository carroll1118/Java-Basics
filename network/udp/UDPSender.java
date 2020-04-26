package network.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 *
 * UDP发送端代码实现
 */
public class UDPSender {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动~~~");
        String message = "今晚,约吗？";

        byte[] buf = message.getBytes();
        // 创建数据包对象
        DatagramPacket dp = new DatagramPacket(buf,buf.length,
                InetAddress.getLocalHost(),6666);
        // 创建发送端的发送对象
        DatagramSocket socket = new DatagramSocket(8888);
        // 发送数据包
        socket.send(dp);
        socket.close();
        System.out.println("客户端关闭~~~");
    }
}
