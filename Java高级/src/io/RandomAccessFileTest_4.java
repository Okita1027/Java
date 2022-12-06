package io;

import java.io.*;

//利用RandomAccessFile类的读写一行数据的方法readLine()，将文本文件的内容读出并显示出来中
//注意：RandomAccessFile 读写文件时，不管文件的编码格式是什么，用 readLine() 都会将编码格式转换成 ISO-8859-1，所以输出显示是还要在进行一次转码
public class RandomAccessFileTest_4
{
  public static void main(String[] args) 
  {
  		try	
		{
		    RandomAccessFile raf=new RandomAccessFile("f:\\java_utf.txt","rw");
			
			long fpoint=0;
			long length=raf.length();
			while(fpoint<length)
			{
				String str=new String(raf.readLine().getBytes("ISO-8859-1"),"utf-8");
				System.out.println(str);
				fpoint=raf.getFilePointer();
			}
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
