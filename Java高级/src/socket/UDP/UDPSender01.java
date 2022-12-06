package socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @time 2022/4/23 20:12 星期六
 * UDP-发送端
 */
public class UDPSender01
{
    public static void main(String[] args) throws Exception
    {
        //创建DatagramSocket对象，准备在9998端口接受数据
        DatagramSocket socket = new DatagramSocket(9998);
        //将需要发送的数据，封装到DatagramPacket对象
        byte[] data = "hello,UDP-Receiver".getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.1.4"), 9999);
        socket.send(packet);
        //关闭资源
        socket.close();
        System.out.println("发送端（UDP-Sender）退出……");
    }
}
