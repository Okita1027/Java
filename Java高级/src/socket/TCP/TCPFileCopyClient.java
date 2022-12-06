package socket.TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @time 2022/4/23 13:59 星期六
 */
public class TCPFileCopyClient
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        String srcFilePath = "F:\\Java\\文档\\JavaSE\\FireGirl.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFilePath));
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);
        socket.shutdownOutput();

        BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());
        String s = StreamUtils.streamToString(inputStream);
        System.out.println("接收到来自服务端的消息：" + s);

        inputStream.close();
        outputStream.close();
        bis.close();
        socket.close();
    }
}
