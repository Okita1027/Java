package io;

import java.io.File;

public class ListDirAndFileTest
{
    public static void main(String[] args)
    {
        File f = new File("c:/");
        File[] fs = f.listFiles();
        for (int i = 0; i < fs.length; i++)
        {
            if (fs[i].isDirectory())
                System.out.println("文件夹：" + fs[i].getName());
            else
                System.out.println("文件:" + fs[i].getName());
        }
    }
}
