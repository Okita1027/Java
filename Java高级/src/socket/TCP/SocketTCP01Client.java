package socket.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @time 2022/4/23 9:17 星期六
 * 客户端向服务端发送hello，server
 */
public class SocketTCP01Client
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

        //关闭流对象和socket
        outputStream.close();
        socket.close();
        System.out.println("客户端退出……");
    }
}
