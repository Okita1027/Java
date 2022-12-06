package io;

import java.io.*;
import java.util.Scanner;

//通过文件字符流实现文本文件的复制
public class CharStream_CopyFileTest2
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
        Reader reader = new FileReader(strin);
        Writer writer = new FileWriter(strout);

        int c;
        long start = System.currentTimeMillis();

        BufferedReader bufferedReader = new BufferedReader(reader);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        //写入数据
        String line = bufferedReader.readLine();
        while (line != null)
        {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            line = bufferedReader.readLine();
        }
        //关闭流
        bufferedReader.close();
        bufferedWriter.close();
        reader.close();
        writer.close();

        long end = System.currentTimeMillis();
        System.out.println("文件复制结束！\n用时：" + (end-start) + "ms");
    }
}
