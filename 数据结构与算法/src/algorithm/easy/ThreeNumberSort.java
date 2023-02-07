package algorithm.easy;

import java.util.Random;

/**
 * @Author qzy
 * @ClassName ThreeNumberSort
 * @Description 排序3个数
 * @Date 2023/2/3 22:45 星期五
 */
public class ThreeNumberSort {
    public static void main(String[] args) {
        final Random random = new Random();
        //生成1-10随机数
        int a = random.nextInt(9) + 1;
        int b = random.nextInt(9) + 1;
        int c = random.nextInt(9) + 1;
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a > c) {
            int temp = a;
            a = c;
            c = temp;
        }
        if (b > c) {
            int temp = b;
            b = c;
            c = temp;
        }
        System.out.print(a);
        System.out.print(b);
        System.out.print(c);
    }
}
