package socket.Exerciese;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @time 2022/4/25 21:00 星期一
 */
public class Homework03Server
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        String fileName = "";
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            fileName += new String(bytes, 0, bytes.length);
        }
        System.out.println(123);
        System.out.println(fileName);
        System.out.println(123);
        FileInputStream fis = new FileInputStream(fileName);
        byte[] allBytes = fis.readAllBytes();
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(allBytes);
        socket.shutdownOutput();

        bos.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
