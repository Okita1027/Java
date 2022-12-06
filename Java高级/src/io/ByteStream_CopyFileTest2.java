package io;

import java.io.*;
import java.util.Scanner;

//通过文件字节流实现文件的复制
public class ByteStream_CopyFileTest2
{
    @SuppressWarnings({"all"})
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入源文件完整路径及名称：");
        String strin = scanner.next();
        //目标文件可以不存在
        System.out.println("请输入目标文件完整路径及名称：");
        String strout = scanner.next();
        //创建文件输入/输出字节流
        FileInputStream in = new FileInputStream(strin);
        FileOutputStream out = new FileOutputStream(strout);

//        缓存流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);

//        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(new FileInputStream("c:/test/src.txt")));
//        String a = bufferedReader.readLine();
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:/test/dest2.txt",true),"utf-8"));
//        bufferedWriter.write(a);
//        bufferedReader.close();
//        bufferedWriter.flush();
//        bufferedWriter.close();

        int c;
        long start = System.currentTimeMillis();

        //写入数据
        byte buff[] = new byte[4096];
        while ((c = in.read(buff)) != -1) {
            out.write(c);
        }

        long end = System.currentTimeMillis();
        System.out.println("文件复制结束！\n用时：" + (end-start) + "ms");

        //关闭流
        bufferedInputStream.close();
        bufferedOutputStream.close();
        in.close();
        out.close();
    }
}