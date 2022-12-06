package io;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.File;

public class JFileChooserTest extends JFrame implements ActionListener
{
	JPanel p1,p2;
	JLabel lb1,lb2;
	JTextField tf1,tf2;
	JButton bt1,bt2;
	JFileChooser fileChooser;
    public JFileChooserTest(String title)
    { 
    	super(title);      
        
        p1=new JPanel();
		p2=new JPanel();
		
		setLayout(new GridLayout(2,1));
   
   		lb1=new JLabel("你所打开的文件是：");
   		tf1=new JTextField(20);
   		bt1=new JButton("打开...");
        p1.add(lb1);
		p1.add(tf1);
		p1.add(bt1);
		p1.setBorder(BorderFactory.createTitledBorder("打开文件"));
		
		lb2=new JLabel("你要另存的文件是：");
   		tf2=new JTextField(20);
   		bt2=new JButton("另存为...");
        p2.add(lb2);
		p2.add(tf2);
		p2.add(bt2);
		p2.setBorder(BorderFactory.createTitledBorder("另存文件"));

		add(p1);
		add(p2);
		
		fileChooser = new JFileChooser();
        
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
        setSize(500,200);
        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize(); 
        setLocation((ss.width-this.getWidth())/2,(ss.height-this.getHeight())/2);
        setResizable(false);
        setVisible(true); 
    }	
  
    public void actionPerformed(ActionEvent e)
    {
        Object obj=e.getSource();
		if(obj==bt1 )
		{
			fileChooser.setApproveButtonText("打开");
            fileChooser.setDialogTitle("打开文件");
		    int result=fileChooser.showOpenDialog(this);//打开文件对话框
	  	    if (result==JFileChooser.APPROVE_OPTION)  //通过返回值判断
	  	    {
	  	    	File file=fileChooser.getSelectedFile();
	  	    	tf1.setText(file.getPath()+file.getName());
	  	    } 
	  	    else if(result == JFileChooser.CANCEL_OPTION)
	  	    {
	            tf1.setText("您没有选择任何文件!");
	        }	
		}
		else if(obj==bt2)
		{
			fileChooser.setApproveButtonText("保存");
            fileChooser.setDialogTitle("保存文件");
		    int result=fileChooser.showSaveDialog(this); //另存文件对话框
	  	    if (result==JFileChooser.APPROVE_OPTION)   //通过返回值判断
	  	    {
	  	    	File file=fileChooser.getSelectedFile();
	  	    	tf2.setText(file.getPath()+file.getName());
	  	    } 
	  	    else if(result == JFileChooser.CANCEL_OPTION)
	  	    {
	            tf2.setText("您没有选择任何文件!");
	        }	
		}
  	}
  	
  	public static void main(String[] args)
    {
  	    new JFileChooserTest("文件对话框");
    }
  	
  	static
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  //外观设置成你所使用的平台的外观
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}




