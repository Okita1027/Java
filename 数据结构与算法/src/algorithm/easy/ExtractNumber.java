package algorithm.easy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName ExtractNumber
 * @Description 抽取数字的每一位，例如：12345 -> 1 2 3 4 5
 * @Date 2023/2/5 21:02 星期日
 */
public class ExtractNumber {
    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int mod = 10, div = 1;
        while (mod / 10 <= number) {
            list.add(number % mod / div);
            mod *= 10;
            div *= 10;
        }
        /*list.add(number % 10);
        int mod = 100, div = 10, temp;
        while (mod / 10 <= number) {
            temp = number % mod;
            list.add(temp / div);
            div *= 10;
            mod *= 10;
        }*/
        System.out.println("这个数是" + list.size() + "位数");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }

    }
}
