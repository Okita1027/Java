package algorithm.easy;

import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName IsLeapYear
 * @Description 判断是否为闰年
 * @Date 2023/2/27 22:43 星期一
 */
public class IsLeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if (year % 400 == 0 || year % 100 != 0 && year % 4 == 0) {
            System.out.println(year + "is leap year!");
        }
    }
}
