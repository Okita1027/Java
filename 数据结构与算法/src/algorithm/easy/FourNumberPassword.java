package algorithm.easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName FourNumberPassword
 * @Description 某个公司采用公话传递数据，数据是四位的整数，在传递过程中数据加密，加密规则如下：
 * 每位数字都加上5，然后用所得结果除以10的余数代替该数字，再将第一位和第四位数交换，第二位和第三位数交换
 * @Date 2023/2/11 21:59 星期六
 */
public class FourNumberPassword {
    public static void main(String[] args) {
        final Random random = new Random();
        //随机生成4位数字
        final int number = random.nextInt(9000) + 1000;
        System.out.println("number = " + number);
        int one, two, three, four;
        one = number / 1000;
        two = number % 1000 / 100;
        three = number % 100 / 10;
        four = number % 10;
        int temp1 = (one + 5) % 10;
        one = (four + 5) % 10;
        four = temp1;
        temp1 = (two + 5) % 10;
        two = (three + 5) % 10;
        three = temp1;
        System.out.print(one);
        System.out.print(two);
        System.out.print(three);
        System.out.println(four);


        //猜数
        final Scanner scanner = new Scanner(System.in);
        int guess;
        while ((guess = scanner.nextInt()) != number) {
            if (guess > number) {
                System.out.println("太大了！");
            } else {
                System.out.println("太小了");
            }
        }
        System.out.println("猜对了：" + number);
    }
}
