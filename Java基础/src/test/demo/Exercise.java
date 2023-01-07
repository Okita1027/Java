package test.demo;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName Exercise
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/27 14:46 星期二
 */
public class Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();

        int i = 0;
        int spaceNum = 0;
        int lastIndexOf = sentence.lastIndexOf(' ');
        System.out.println("lastIndexOf = " + lastIndexOf);
        while (i != lastIndexOf + 1) {
            if (sentence.charAt(i++) == ' ') {
                spaceNum++;
            }
        }

        System.out.println("spaceNum = " + spaceNum);
    }

    @Test
    void test01() {
        /*
        请设计出一个程序，用于实现输入一段英文句子，从而检测出其中所包含的单词数量，规定输入的句子中只包含英文字母和空格，且单词与单词之间用一个空格间隔，单词中的字母不区分大小写，默认小写。
        样例输入：
        everyone is an undergraduate
        样例输出：
        4
         */
        String s = "1 2 3 4";
        System.out.println(s.lastIndexOf(' '));
    }
}
