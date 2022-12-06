package io;

import java.io.*;
//利用RandomAccessFile类的获取长度方法length()、移动文件位置指针方法seek()、skipBytes()等，对文件进行随机读写操作
public class RandomAccessFileTest_2
{
  public static void main(String[] args) 
  {
  		try	
		{
		    File f=new File("f:\\ratest1.dat");
		    RandomAccessFile raf=new RandomAccessFile(f,"rw"); //打开以便读取和写入,如果该文件尚不存在，则创建该文件
		    
		    String s="TestString";
		    System.out.println("在文件末尾追加数据：");
		    long len=raf.length();
		    raf.seek(len);                                      //文件指针指向文件尾
		    raf.writeUTF(s);
		    
		    System.out.println("读取刚存入的数据：");
		    raf.seek(len);                                       //文件指针指向刚存入数据处
		    System.out.println(raf.readUTF());
		    
		    System.out.println("读取最初数据：");
		    raf.seek(0);
		    System.out.println(raf.readInt());
		    
		    System.out.println("跳过double型数据读取第一个String数据：");
		    raf.skipBytes(8);
		    System.out.println(raf.readUTF());
		    
		    raf.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("找不到文件：");
		    e.printStackTrace();
		} 
		catch (IOException e) 
		{
		    System.out.println("输入输出出错：");
		    e.printStackTrace();
		} 
		catch(Exception e)
        {
        	System.out.println("其它错误：");
      		e.printStackTrace();
        }
        
    
  }
}
