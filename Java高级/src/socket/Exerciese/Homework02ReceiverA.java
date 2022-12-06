package socket.Exerciese;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @time 2022/4/23 22:09 星期六
 * 接收端A
 */
public class Homework02ReceiverA
{
    public static void main(String[] args) throws IOException
    {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        System.out.println("等待接受数据……");
        socket.receive(packet);

        bytes = packet.getData();
        int length = packet.getLength();
        String result = new String(bytes, 0, length);
        System.out.println("收到来自SenderB发送的信息:\n" + result);

        String answer = "《红楼梦》《水浒传》《三国演义》《西游记》";
        bytes = answer.getBytes();
        packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.1.4"), 9998);
        socket.send(packet);

        socket.close();
        System.out.println("Receiver-A退出……");
    }
}
