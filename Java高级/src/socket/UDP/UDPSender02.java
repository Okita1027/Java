package socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @time 2022/4/23 20:12 星期六
 * UDP-发送端02
 */
public class UDPSender02
{
    public static void main(String[] args) throws Exception
    {
        //创建DatagramSocket对象，准备在9998端口接受数据
        DatagramSocket socket = new DatagramSocket(9998);
        //将需要发送的数据，封装到DatagramPacket对象
        byte[] data = "hello,UDP-02A".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.1.4"), 9999);
        socket.send(packet);
        //关闭资源
//        socket.close();
//        System.out.println("发送端（UDP-Sender02）退出……");

        System.out.println("UDP-02B等待接收数据……");
        socket.receive(packet);
        byte[] bytes = packet.getData();
        int length = packet.getLength();
        String result = new String(bytes, 0, length);
        System.out.println("result = " + result);

        socket.close();
    }
}
