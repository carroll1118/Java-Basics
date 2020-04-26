package network;
/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 */

import java.net.InetAddress;

/**
 InetAddress类概述
 * 一个该类的对象就代表一个IP地址对象。

 InetAddress类成员方法
 * static InetAddress getLocalHost()
 * 获得本地主机IP地址对象
 * static InetAddress getByName(String host)
 * 根据IP地址字符串或主机名获得对应的IP地址对象

 * String getHostName();获得主机名
 * String getHostAddress();获得IP地址字符串
 */
public class InetAddressDemo01 {
    public static void main(String[] args) throws Exception {
        // 获得本地主机IP地址对象
        InetAddress inet01 = InetAddress.getLocalHost();
        System.out.println(inet01);
        // 根据IP地址字符串或主机名获得对应的IP地址对象
        InetAddress inet02 = InetAddress.getByName("taobao.com");
        System.out.println(inet02);

        String hostName = inet01.getHostName();
        System.out.println(hostName);

        // 获得IP地址字符串
        String hostAddress = inet01.getHostAddress();
        System.out.println(hostAddress);
    }
}
