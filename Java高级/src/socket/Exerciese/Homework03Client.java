package socket.Exerciese;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @time 2022/4/25 21:00 星期一
 */
public class Homework03Client
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件名：");
        String filePath = scanner.next();

        OutputStream outputStream = socket.getOutputStream();
        System.out.println(filePath);
        outputStream.write(filePath.getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = bis.readAllBytes();
        FileOutputStream fos = new FileOutputStream("网络\\FireGirl2.jpg");
        fos.write(bytes);

        fos.close();
        bis.close();
        outputStream.close();
        socket.close();
    }
}
