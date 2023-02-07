package test.demo;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName Exercise
 * @Description 统计
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
}
