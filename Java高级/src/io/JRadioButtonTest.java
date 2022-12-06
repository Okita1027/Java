package io;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("all")
public class JRadioButtonTest extends JFrame implements ActionListener
{
    public static void main(String[] args)
    {
        new JRadioButtonTest("文件对话框");
    }

    JPanel PanelOpen, PanelSaveas;
    JButton BtnOpen, BtnSaveAs;
    JTextField TextFieldOpen, TextFieldSaveAs;
    JLabel LableOpen, LableSaveas;

    public JRadioButtonTest(String title)
    {
        super(title);
        setLayout(new GridLayout(2, 1));

        PanelOpen = new JPanel();
        PanelSaveas = new JPanel();
        BtnOpen = new JButton("打开...");
        BtnSaveAs = new JButton("另存为...");
        TextFieldOpen = new JTextField(20);
        TextFieldSaveAs = new JTextField(20);
        LableOpen = new JLabel("你所打开的文件是：");
        LableSaveas = new JLabel("你要另存的文件是：");

        PanelOpen.setLayout(new FlowLayout());
        PanelSaveas.setLayout(new FlowLayout());
        PanelOpen.setBorder(BorderFactory.createTitledBorder("打开文件"));
        PanelSaveas.setBorder(BorderFactory.createTitledBorder("另存文件"));

        PanelOpen.add(LableOpen);
        PanelOpen.add(TextFieldOpen);
        PanelOpen.add(BtnOpen);
        PanelSaveas.add(LableSaveas);
        PanelSaveas.add(TextFieldSaveAs);
        PanelSaveas.add(BtnSaveAs);

        add(PanelOpen);
        add(PanelSaveas);

        BtnOpen.addActionListener(this);
        BtnSaveAs.addActionListener(this);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize(500, 200);
        setLocation((width - this.getWidth())/2, (height - this.getHeight())/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object obj = e.getSource();
        if (obj == BtnOpen)
        {
            //打开文件对话框
            FileDialog fileDialog = new FileDialog(this, "打开文件", FileDialog.LOAD);
            fileDialog.setVisible(true);
            String path = fileDialog.getDirectory();    //获得文件路径
            String file = fileDialog.getFile();         //获得文件名
            if (path != null && file != null)
                TextFieldOpen.setText(path + file);
        }
        else if (obj == BtnSaveAs)
        {
            //打开文件另存为对话框
            FileDialog fileDialog = new FileDialog(this, "另存文件", FileDialog.SAVE);
            fileDialog.setVisible(true);
            String path = fileDialog.getDirectory();
            String file = fileDialog.getFile();
            if (path != null && file != null)
                TextFieldSaveAs.setText(path + file);
        }
    }
}
