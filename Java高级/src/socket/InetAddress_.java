package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @time 2022/4/23 9:02 星期六
 * InetAddress常用方法
 */
public class InetAddress_
{
    public static void main(String[] args) throws UnknownHostException
    {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localHost = " + localHost);

        InetAddress localIP = InetAddress.getByName("192.168.1.4");
        System.out.println("localIP = " + localIP);

        InetAddress host1 = InetAddress.getByName("DESKTOP-LSR1B82");
        System.out.println("host1 = " + host1);

        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2 = " + host2);

        String hostAddress = host2.getHostAddress();
        String hostName = host2.getHostName();
        System.out.println("hostName = " + hostName);
        System.out.println("hostAddress = " + hostAddress);
    }
}
