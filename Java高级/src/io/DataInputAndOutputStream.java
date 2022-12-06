package io;

import java.io.*;

public class DataInputAndOutputStream
{
    public static void main(String[] args)
    {
        int[] fib = new int[20];
        fib[1] = fib[0] = 1;
        for (int i = 2; i < 20; i++)
            fib[i] = fib[i-1] + fib[i-2];

        try
        {
            OutputStream fos = new FileOutputStream("c:/test/fib.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            for (int i = 0; i < 20; i++)
                dos.writeInt(fib[i]);
            dos.close();
            fos.close();
            System.out.println("文件创建完毕，数据已写入！");

            InputStream fis = new FileInputStream("c:/test/fib.dat");
            DataInputStream dis = new DataInputStream(fis);
            for (int i = 0; i < 20; i++)
                System.out.println(dis.readInt());
            fis.close();
            dis.close();
            System.out.println("文件数据已读出！");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("文件没找到！");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("其他错误！");
            e.printStackTrace();
        }

    }
}
