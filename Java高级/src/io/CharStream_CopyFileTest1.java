package io;

import java.io.*;
import java.util.Scanner;

//通过文件字符流实现文本文件的复制
public class CharStream_CopyFileTest1
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
        //创建文件字符输入输出流
        Reader in = new FileReader(strin);
        Writer out = new FileWriter(strout);

        int c;
        long start = System.currentTimeMillis();

        //写入数据
        while ((c = in.read()) != -1)
            out.write(c);
        //关闭流
        in.close();
        out.close();

        long end = System.currentTimeMillis();
        System.out.println("文件复制结束！\n用时：" + (end-start) + "ms");
    }
}
