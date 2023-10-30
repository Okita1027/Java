package lesson.homework;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author qzy
 * @time 2023/10/23 10:29 星期一
 * @title 计算器
 */
public class CalculatorGUI extends JFrame {

    JFrame frame = new JFrame("算数测试");
    JTextField left = new JTextField(5);
    JTextField right = new JTextField(5);
    JTextField expression = new JTextField(1);
    JTextField equals = new JTextField("=", 1);
    JTextField result = new JTextField(5);
    JTextField message = new JTextField(8);
    JButton btn1 = new JButton("获取答案");
    JButton btn2 = new JButton("获取题目");

    public CalculatorGUI() throws HeadlessException {
        left.setEditable(false);
        right.setEditable(false);
        expression.setEditable(false);
        expression.setBorder(null);
        message.setEditable(false);
        message.setBorder(null);
        equals.setEditable(false);
        equals.setBorder(null);

        btn2.addActionListener(e -> {
            if (e.getSource() == btn2) {
                Random random = new Random();
                left.setText(String.valueOf(random.nextInt(100)));
                right.setText(String.valueOf(random.nextInt(100)));
                expression.setText(random.nextBoolean() ? "+" : "-");
            }
        });

        btn1.addActionListener(e -> {
            if (e.getSource() == btn1) {
                if (left.getText().isEmpty() || right.getText().isEmpty() || result.getText().isEmpty()) {
                    return;
                }
                int res = Integer.parseInt(result.getText());
                String expr = expression.getText();
                if (expr.equals("+")) {
                    if (Integer.parseInt(left.getText()) + Integer.parseInt(right.getText()) == res) {
                        message.setText("你回答正确");
                    } else {
                        message.setText("你回答错误");
                    }
                } else {
                    if (Integer.parseInt(left.getText()) - Integer.parseInt(right.getText()) == res) {
                        message.setText("你回答正确");
                    } else {
                        message.setText("你回答错误");
                    }
                }
            }
        });


        frame.add(left);
        frame.add(expression);
        frame.add(right);
        frame.add(equals);
        frame.add(result);
        frame.add(btn1);
        frame.add(message);
        frame.add(btn2);

        frame.setLayout(new FlowLayout());
        frame.setBounds(500, 300,550, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
