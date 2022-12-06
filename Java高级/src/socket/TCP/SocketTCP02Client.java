package socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @time 2022/4/23 9:17 星期六
 * 客户端向服务端发送hello，server
 * 服务端再向客户端发送hello，client
 */
public class SocketTCP02Client
{
    public static void main(String[] args) throws IOException
    {
        //连接服务器（IP,端口）
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端socket返回 = " + socket);
        //连接成功后，生成Socket获取socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流，写入数据到数据通道
        outputStream.write("hello,server".getBytes(StandardCharsets.UTF_8));
        //这句话表明客户端要发送的数据到这就结束了，不写的话服务端就会一直等待客户端发送数据，程序会卡死
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] buff = new byte[1024];
        int readLen = 0;
        System.out.println("接收到来自服务端（Server）的消息：");
        while ((readLen = inputStream.read(buff)) != -1)
        {
            System.out.println(new String(buff, 0, readLen));
        }

        //关闭流对象和socket
        outputStream.close();
        inputStream.close();
        socket.close();
        System.out.println("客户端退出……");
    }
}
