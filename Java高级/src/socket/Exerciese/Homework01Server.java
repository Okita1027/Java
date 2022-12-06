package socket.Exerciese;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @time 2022/4/23 21:39 星期六
 * Server
 */
public class Homework01Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        System.out.println("服务端等待接受数据中……");
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result = reader.readLine();
        System.out.println("来自客户端的消息：" + result);
        String response;
        if (result.equals("name"))
            response = "QinZhiyun";
        else if (result.equals("hobby"))
            response = "Java Programming";
        else
            response = "What are you talking about ?";

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(response.getBytes(StandardCharsets.UTF_8));

        bos.close();
        reader.close();
        socket.close();
        serverSocket.close();
    }
}
