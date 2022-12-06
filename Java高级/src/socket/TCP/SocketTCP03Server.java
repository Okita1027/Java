package socket.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @time 2022/4/23 13:14 星期六
 */
public class SocketTCP03Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端等待中……");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println("接受到来自客户端的消息：");
        System.out.println(bufferedReader.readLine());

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("hello, client(字符流)");
        bufferedWriter.newLine();//插入一个换行符，表示写入的内容结束，此时服务端必须使用readLine()读取
        bufferedWriter.flush();//若使用字符流，必须手动刷新，否则数据不会写入通道

        //socket.shutdownOutput();//由于使用了newLine()，所以这句话可以省了

        bufferedWriter.close();//后打开的流先关闭
        //inputStream.close();
        bufferedReader.close();//关闭外层IO流就行了，因此上面那句话省略
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出……");

    }
}
