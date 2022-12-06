package socket.Exerciese;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @time 2022/4/23 21:39 星期六
 * Client
 */
public class Homework01Client
{
    public static void main(String[] args) throws IOException
    {
        Socket socket = new Socket(InetAddress.getByName("192.168.1.4"), 9999);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        System.out.println("请输入您的问题：");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();

        writer.write(next);
        writer.newLine();
        writer.flush();

        int readLen = 0;
        byte[] bytes = new byte[1024];
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        System.out.print("收到来自服务端的消息：");
        while ((readLen = bis.read(bytes, 0, bytes.length)) != -1)
        {
            System.out.print(new String(bytes, 0, bytes.length));
        }

        bis.close();
        writer.close();
        socket.close();
    }
}
