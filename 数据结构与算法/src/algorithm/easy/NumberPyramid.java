package algorithm.easy;

import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName Pyramid
 * @Description 数字金字塔
 * @Date 2023/1/25 22:09 星期三
 */
public class NumberPyramid {
    public static void main(String[] args) {
        int level = new Scanner(System.in).nextInt();
        for (int i = 1; i <= level; i++) {
            for (int j = level; j > i; j--) {
                System.out.print("  ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(2 * j + 1 + " ");
            }
            for (int j = i - 1; j > 0; j--) {
                System.out.print(2 * j - 1 + " ");
            }
            System.out.println();
        }
    }
}
