package socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @time 2022/4/23 20:13 星期六
 * UDP-接收端
 */
public class UDPReceiver01
{
    public static void main(String[] args) throws IOException
    {
        //创建DatagramSocket对象，准备在9999端口接受数据
        DatagramSocket socket = new DatagramSocket(9999);
        //创建DatagramPacket对象，准备接受数据
        byte[] bytes = new byte[1024];//UDP协议中单个数据包最大为 64k
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        //调用receive方法，将通过网络传输的DatagramPacket对象填充到packet对象
        //有数据包发送到本机的9999端口时，就会接受到数据，否则程序阻塞等待
        System.out.println("UDP-接收端等待接收数据……");
        socket.receive(packet);
        //收到数据后，进行拆包
        int length = packet.getLength();
        byte[] data = packet.getData();
        String result = new String(data, 0, length);
        System.out.println("result = " + result);
        socket.close();
        System.out.println("接收端（UDP-Receiver）退出……");
    }
}
