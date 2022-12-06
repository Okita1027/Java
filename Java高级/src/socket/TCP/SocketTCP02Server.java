package socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @time 2022/4/23 11:12 星期六
 * 客户端向服务端发送hello，server
 * 服务端再向客户端发送hello，client
 */
public class SocketTCP02Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器9999号端口监听中，等待连接……");
        //当没有客户端连接时，程序会卡在这
        Socket socket = serverSocket.accept();
        System.out.println("服务器端socket = " + socket);
        //通过socket.getInputStream()获取端口对应的输入流
        InputStream inputStream = socket.getInputStream();
        byte[] buff = new byte[1024];
        int readLen = 0;
        System.out.println("接收到来自客户端（Client）的消息：");
        while ((readLen = inputStream.read(buff)) != -1)
        {
            System.out.println(new String(buff, 0, readLen));
        }
        //接受到来自客户端（Client）的消息之后，再发送hello,client返回给客户端（Client）
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes(StandardCharsets.UTF_8));
        //这句话表明服务端要发送的数据到这就结束了，不写的话客户端就会一直等待服务端发送数据，程序会卡死
        socket.shutdownOutput();
        //关闭socket和IO流
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出……");
    }
}
