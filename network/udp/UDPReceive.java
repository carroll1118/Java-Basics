package network.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 *
 * UDP协议接收端代码实现
 */
public class UDPReceive {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动~~~");
        // 创建接收对象ds
        DatagramSocket ds = new DatagramSocket(6666);
        byte[] buf = new byte[1024];
        //创建数据包对象
        DatagramPacket dp = new DatagramPacket(buf,buf.length);
        ds.receive(dp);

        int len = dp.getLength();
        System.out.println("len="+len);

        // 将字节数组的内容转换为字符串输出
        System.out.println(new String(buf,0,len));
        // 获得发送端的ip地址
        String sendIp = dp.getAddress().getHostAddress();
        // 获得发送端的端口号
        int port = dp.getPort();
        System.out.println(sendIp);
        System.out.println(port);

        ds.close();
        System.out.println("服务端关闭~~~");

    }
}
