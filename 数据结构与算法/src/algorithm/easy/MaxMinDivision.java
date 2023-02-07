package algorithm.easy;

/**
 * @Author qzy
 * @ClassName MaxMinDivision
 * @Description 最大公约数、最小公倍数
 * @Date 2023/2/2 22:41 星期四
 */
public class MaxMinDivision {
    public static void main(String[] args) {
        int a = 6, b = 4;
        int division = division(a, b);
        System.out.println("最大公约数为：" + division);
        System.out.println("最小公倍数为：" + a * b / division);
    }

    private static int division(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            int c = a % b;
            //除数作被除数
            a = b;
            //余数作除数
            b = c;
        }
        return a;
    }
}
