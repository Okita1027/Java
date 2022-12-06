package io;

import java.io.File;

public class CreateDirTest
{
    public static void main(String[] args)
    {
        File f = new File("D:/test");
        if (f.exists())
        {
            System.out.println("文件夹已经存在！");
        }
        else
        {
            try
            {
                if (f.mkdir())
                {
                    System.out.println("文件夹创建完毕！");
                }
                else
                {
                    System.out.println("文件夹创建失败！");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("文件夹创建失败！");
            }
        }
    }
}
