package algorithm.easy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName PrimeFactor
 * @Description 分解质因数：90 = 2 * 3 * 3 * 5
 * @Date 2023/2/10 14:43
 */
public class PrimeFactor {
    public static void main(String[] args) {

        /*Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                num /= i;
                System.out.println(i);
            }
        }*/

        int num = new Scanner(System.in).nextInt();
        int temp = num;
        ArrayList<Integer> list = new ArrayList<>();

        while (temp != 1) {
            for (int i = 2; i <= temp; i++) {
                if (temp % i == 0) {
                    temp /= i;
                    list.add(i);
                    break;
                }
            }
        }

        if (list.size() == 1) {
            return;
        }

        System.out.print(num + " = ");
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + " * ");
        }
        System.out.println(list.get(list.size() - 1) + ";");

    }
}
