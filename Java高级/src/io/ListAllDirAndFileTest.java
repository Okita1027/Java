package io;

import java.io.*;

public class ListAllDirAndFileTest 
{
	public static void main(String[] args) 
	{
		File f = new File("c:/");
		//File f = new File(System.getProperty("user.dir"));
		
		if(f.isDirectory())
			  System.out.println("目录: "+f.getName());
		else 
			  System.out.println("文件: "+f.getName());
			       		
		ExpandTree(f, 1);
	}
	
	private static void ExpandTree(File f, int level) 
	{
		String preBlank="";
		for(int i=0; i<level; i++) 
		{
			preBlank= preBlank+"    ";
		}
		
		File[] childs = f.listFiles();
		for(int i=0; i<childs.length; i++) 
		{
			if(childs[i].isDirectory())
			  	 System.out.println(preBlank + "目录: "+childs[i].getName());
			else 
			 	 System.out.println(preBlank + "文件: "+childs[i].getName());	
			
			if(childs[i].isDirectory()) 
			{
				ExpandTree(childs[i], level + 1);
			}
		
		}
	}
}
