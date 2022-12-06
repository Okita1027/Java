package io;

import java.io.*;
public class InputStreamReaderTest2
{	
	public static void main(String[] args) 	
	{		
		try	
		{
			InputStream fis = new FileInputStream("f:\\java.txt");
			InputStreamReader isr = new InputStreamReader(fis,"GB2312");  
			BufferedReader br= new BufferedReader(isr);
			
			StringBuffer text=new StringBuffer("");
			String str= br.readLine();
			while (str!=null)  //
			{	
				text.append(str);
				text.append(System.getProperty("line.separator"));
				str= br.readLine();	
			}
			br.close();
			isr.close();
			fis.close();
			
			System.out.println("文件内容如下：");
			System.out.println(text.toString());
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

	