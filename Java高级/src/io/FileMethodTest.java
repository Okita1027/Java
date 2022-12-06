package io;

import java.io.File;
import java.util.Date;

public class FileMethodTest
{
    public static void main(String[] args)
    {
        File f = new File("d:/test/abc.txt");
        if (f.exists())
        {
            //文件名称
            System.out.println(f.getName());
            //文件所在路径
            System.out.println(f.getPath());
            //文件所在绝对路径
            System.out.println(f.getAbsolutePath());
            //父目录名称
            System.out.println(f.getParent());
            //文件长度
            System.out.println(f.length());
            //文件最后一次修改时间
            System.out.println(new Date(f.lastModified()));
            //路径分隔符
            System.out.println(System.getProperty("file.separator"));
            //文件是否可执行
            System.out.println(f.canExecute());
            //文件是否可读
            System.out.println(f.canRead());
            //文件是否可写
            System.out.println(f.canWrite());
            //是否是一个目录
            System.out.println(f.isDirectory());
            //是否是文件
            System.out.println(f.isFile());
            //是否是一个隐藏文件
            System.out.println(f.isHidden());
        }
        else
        {
            System.out.println("文件不存在");
        }
    }
}
