package socket.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @time 2022/4/23 13:59 星期六
 */
public class TCPFileCopyServer
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端的9999端口监听中……");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = StreamUtils.streamToByteArray(inputStream);

        String destFilePath = "网络\\FireGirl.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("已收到！");
        writer.flush();
        socket.shutdownOutput();

        writer.close();
        bos.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出……");
    }
}
