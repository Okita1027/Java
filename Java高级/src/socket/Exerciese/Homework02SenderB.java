package socket.Exerciese;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @time 2022/4/23 22:09 星期六
 * 发送端B
 */
public class Homework02SenderB
{
    public static void main(String[] args) throws IOException
    {
        DatagramSocket socket = new DatagramSocket(9998);
        byte[] data = "四大名著是哪些？".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.1.4"), 9999);
        socket.send(packet);

        System.out.println("等待接受数据……");
        socket.receive(packet);

        int length = packet.getLength();
        data = packet.getData();
        String result = new String(data, 0, length);
        System.out.println("收到来自ReceiverA发送的信息：\n" + result);

        socket.close();
        System.out.println("Sender-B退出……");
    }
}
