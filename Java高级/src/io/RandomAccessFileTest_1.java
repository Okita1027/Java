package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest_1
{
    public static void main(String[] args)
    {
        try
        {
            File file = new File("C:/test/exercise.txt");
            RandomAccessFile randomAccessFile1 = new RandomAccessFile(file, "rw");

            int a = 10;
            double b = 12.34;
            String c = "abc";

            randomAccessFile1.writeInt(a);
            randomAccessFile1.writeDouble(b);
            randomAccessFile1.writeUTF(c);
            randomAccessFile1.close();
            System.out.println("文件创建完毕！");

            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");

            System.out.println("开始读取文件：");
            a = randomAccessFile2.readInt();
            b = randomAccessFile2.readDouble();
            c = randomAccessFile2.readUTF();

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);

            System.out.println("读取完成！");
            randomAccessFile2.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
