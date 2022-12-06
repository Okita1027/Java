package io;

import java.io.File;
import java.io.IOException;

public class CreateFileTest
{
    public static void main(String[] args)
    {
        File f = new File("D:/test/abc.txt");
        //File f = new File("d:" + System.getProperty(("file.separator") + "test" + File.separator + "abc.txt"));
        if (f.exists())
        {
            System.out.println("文件已存在！");
        }
        else
        {
            try
            {
                if (f.createNewFile())
                {
                    System.out.println("文件已创建成功！");
                }
            }
            catch (IOException e)
            {
                System.out.println("输入输出错误：");
                e.printStackTrace();
            }
            catch (Exception e)
            {
                System.out.println("其它错误：");
                e.printStackTrace();
            }
        }
    }
}
