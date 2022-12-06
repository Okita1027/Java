package io;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

@SuppressWarnings({"all"})
public class CopyFileByFileDialogTest extends JFrame implements ActionListener
{
    public static void main(String[] args)
    {
        new CopyFileByFileDialogTest("文件的复制");
    }

    JPanel pnlSrc, pnlDest, pnlStyle, pnlBuff, pnlCopy, pnlRes;
    JLabel lblSrc, lblDest, lblRes;
    JButton btnSrc, btnDest, btnCopy;
    JRadioButton rdoBtnByte, rdoBtnChar, rdoBtnBuffYes, rdoBtnBuffNo;
    ButtonGroup btnGrpStyle, btnGrpBuff;
    JTextField tfSrc, tfDest, tfRes;

    public CopyFileByFileDialogTest(String title)
    {
        super(title);
        setLayout(new GridLayout(3, 2));

        pnlSrc = new JPanel(new FlowLayout());
        pnlDest = new JPanel(new FlowLayout());
        pnlStyle = new JPanel(new FlowLayout());
        pnlBuff = new JPanel(new FlowLayout());
        pnlCopy = new JPanel(new FlowLayout());
        pnlRes = new JPanel(new FlowLayout());

        lblSrc = new JLabel("文件路径：");
        lblDest = new JLabel("文件路径：");
        lblRes = new JLabel("用时：");

        rdoBtnByte = new JRadioButton("字节方式");
        rdoBtnByte.setSelected(true);   //默认选中字节方式
        rdoBtnChar = new JRadioButton("字符方式");
        rdoBtnBuffNo = new JRadioButton("不带缓冲区");
        rdoBtnBuffNo.setSelected(true);//默认选中不带缓冲区
        rdoBtnBuffYes = new JRadioButton("带缓冲区");

        tfSrc = new JTextField(20);
        tfDest = new JTextField(20);
        tfRes = new JTextField(20);
        tfRes.setEditable(false);

        btnSrc = new JButton("源文件...");
        btnDest = new JButton("目标文件...");
        btnCopy = new JButton("开始复制...");

        btnGrpStyle = new ButtonGroup();
        btnGrpBuff = new ButtonGroup();

        pnlSrc.setBorder(BorderFactory.createTitledBorder("源文件"));
        pnlDest.setBorder(BorderFactory.createTitledBorder("目标文件"));
        pnlStyle.setBorder(BorderFactory.createTitledBorder("流的方式"));
        pnlBuff.setBorder(BorderFactory.createTitledBorder("缓冲区"));
        pnlCopy.setBorder(BorderFactory.createTitledBorder("开始复制"));
        pnlRes.setBorder(BorderFactory.createTitledBorder("复制结果"));

        btnGrpStyle.add(rdoBtnByte);
        btnGrpStyle.add(rdoBtnChar);
        btnGrpBuff.add(rdoBtnBuffNo);
        btnGrpBuff.add(rdoBtnBuffYes);

        pnlSrc.add(lblSrc);
        pnlSrc.add(tfSrc);
        pnlSrc.add(btnSrc);
        pnlDest.add(lblDest);
        pnlDest.add(tfDest);
        pnlDest.add(btnDest);
        pnlStyle.add(rdoBtnByte);
        pnlStyle.add(rdoBtnChar);
        pnlBuff.add(rdoBtnBuffNo);
        pnlBuff.add(rdoBtnBuffYes);
        pnlCopy.add(btnCopy);
        pnlRes.add(lblRes);
        pnlRes.add(tfRes);

        add(pnlSrc);
        add(pnlDest);
        add(pnlStyle);
        add(pnlBuff);
        add(pnlCopy);
        add(pnlRes);

        btnSrc.addActionListener(this);
        btnDest.addActionListener(this);
        btnCopy.addActionListener(this);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(1000, 300);
        setLocation((screenSize.width - this.getWidth())/2, (screenSize.height - this.getHeight())/2);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object obj = e.getSource();
        if (obj == btnSrc)
        {
            FileDialog fileDialog = new FileDialog(this, "源文件", FileDialog.LOAD);
            fileDialog.setVisible(true);
            String filePath = fileDialog.getDirectory();
            String fileName = fileDialog.getFile();
            if (filePath != null && fileName != null)
                tfSrc.setText(filePath + fileName);
        }
        else if (obj == btnDest)
        {
            FileDialog fileDialog = new FileDialog(this, "目标文件", FileDialog.SAVE);
            fileDialog.setVisible(true);
            String filePath = fileDialog.getDirectory();
            String fileName = fileDialog.getFile();
            if (filePath != null && fileName != null)
                tfDest.setText(filePath + fileName);
        }
        else if (obj == btnCopy)
        {
            String strin = tfSrc.getText().toString();
            String strout = tfDest.getText().toString();

            if (rdoBtnByte.isSelected() == true)
            {
                //创建文件输入/输出字节流
                FileInputStream in = null;
                FileOutputStream out = null;
                try
                {
                    in = new FileInputStream(strin);
                    out = new FileOutputStream(strout);
                } catch (FileNotFoundException fileNotFoundException)
                {
                    fileNotFoundException.printStackTrace();
                }

                int c;

                //写入数据
                try
                {
                    long start = System.currentTimeMillis();
                    if (rdoBtnBuffYes.isSelected() == true)
                    {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
                        byte buff[] = new byte[4096];
                        while ((c = in.read(buff)) != -1)
                            out.write(c);
                        bufferedInputStream.close();
                        bufferedOutputStream.close();
                        in.close();
                        out.close();
                        long end = System.currentTimeMillis();
                        tfRes.setText(String.valueOf(end-start));
                    }
                    else
                    {
                        start = System.currentTimeMillis();
                        while ((c = in.read()) != -1)
                            out.write(c);
                        long end = System.currentTimeMillis();
                        tfRes.setText(String.valueOf(end-start));
                        in.close();
                        out.close();
                    }
                } catch (IOException ioException)
                {
                    ioException.printStackTrace();
                }
            }

            if (rdoBtnByte.isSelected() == false)
            {
                Reader fileReader = null;
                Writer fileWriter = null;
                try
                {
                    fileReader = new FileReader(strin);
                    fileWriter = new FileWriter(strout);
                } catch (IOException ioException)
                {
                    ioException.printStackTrace();
                }

                int c;
                long start, end;
                if (rdoBtnBuffYes.isSelected() == true)
                {
                    start = System.currentTimeMillis();
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    //写入数据
                    String line = null;
                    try
                    {
                        line = bufferedReader.readLine();
                    } catch (IOException ioException)
                    {
                        ioException.printStackTrace();
                    }
                    while (line != null)
                    {
                        try
                        {
                            bufferedWriter.write(line);
                            bufferedWriter.newLine();
                            line = bufferedReader.readLine();
                        } catch (IOException ioException)
                        {
                            ioException.printStackTrace();
                        }
                    }
                    end = System.currentTimeMillis();
                    tfRes.setText(String.valueOf(end-start));
                    //关闭流
                    try
                    {
                        bufferedReader.close();
                        bufferedWriter.close();
                        fileReader.close();
                        fileWriter.close();
                    } catch (IOException ioException)
                    {
                        ioException.printStackTrace();
                    }
                }
                else
                {
                    start = System.currentTimeMillis();
                    //写入数据
                    try
                    {
                        while ((c = fileReader.read()) != -1)
                            fileWriter.write(c);
                        //关闭流
                        fileReader.close();
                        fileWriter.close();
                    } catch (IOException ioException)
                    {
                        ioException.printStackTrace();
                    }
                    end = System.currentTimeMillis();
                    tfRes.setText(String.valueOf(end-start));
                }
            }
        }
    }
}
