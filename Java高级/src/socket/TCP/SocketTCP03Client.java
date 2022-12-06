package socket.TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @time 2022/4/23 13:14 星期六
 */
public class SocketTCP03Client
{
    public static void main(String[] args) throws IOException
    {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, server(字符流)");
        bufferedWriter.newLine();//插入一个换行符，表示写入的内容结束，此时服务端必须使用readLine()读取
        bufferedWriter.flush();//若使用字符流，必须手动刷新，否则数据不会写入通道

        //socket.shutdownOutput();//由于使用了newLine()，所以这句话可以省了

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("接受到来自服务端的消息：");
        System.out.println(bufferedReader.readLine());

        bufferedReader.close();//后打开的流先关闭
        //outputStream.close();
        bufferedWriter.close();//关闭外层IO流就行了，因此上面那句话省略
        socket.close();
        System.out.println("客户端退出……");

    }
}
