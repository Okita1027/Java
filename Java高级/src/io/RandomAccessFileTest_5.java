package io;

import java.io.*;
//利用RandomAccessFile类,对基本类型数据进行批量读写
public class RandomAccessFileTest_5
{
  public static void main(String[] args) 
  {
  	
  		try	
		{
		    RandomAccessFile raf=new RandomAccessFile("ratest3.dat","rw");
			
			for(int i=0;i<200;i++)
			{
				raf.writeInt(i);
				raf.writeDouble(Math.random());
				raf.writeUTF("String:"+Integer.toString(i));
			}
			raf.close();
			
		    raf=new RandomAccessFile("ratest3.dat","r");
			for(int i=0;i<200;i++)
			{
				int r1=raf.readInt();
				double r2=raf.readDouble();
				String r3=raf.readUTF();
				
				System.out.println(r1+"\t"+r2+"\t"+r3);
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
