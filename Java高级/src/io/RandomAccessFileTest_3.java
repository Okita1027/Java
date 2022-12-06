package io;

import java.io.*;
//利用RandomAccessFile类的读写数据及移动文件位置指针的方法seek()，对文件中int型数据进行随机读写
public class RandomAccessFileTest_3
{
  public static void main(String[] args) 
  {
  		try	
		{
		    int a[]={1,2,3,4,5,6,7,8,9,10};
			int b,i;
	
			//存入数据
			RandomAccessFile raf1=new RandomAccessFile("e:\\ratest2.dat","rw");
			for(i=0;i<10;i++)
			    raf1.writeInt(a[i]);
			raf1.close();
		
			//间隔读出来
			RandomAccessFile raf2=new RandomAccessFile("e:\\ratest2.dat","rw");
			for(i=0;i<10;i+=2)
			{ 
			    raf2.seek(i*4);
			    b=raf2.readInt();
			    System.out.println(b);
			} 
			raf2.close();
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
