package test.book.three;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName Exercise
 * @Description 第三章：选择
 * @Date 2023/1/8 16:47 星期日
 */
public class Exercise {
    @Test
    void test01() {
        final Random random = new Random();
        switch (random.nextInt(13)) {
            case 1:
                System.out.println("January");
                System.out.println("123");
                break;
            case 2:
                System.out.println("February");
                break;
            default:
                System.out.println("123");
                System.out.println("123");
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int temp;
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        if (c < a) {
            System.out.print(c);
            System.out.print(a);
            System.out.print(b);
        } else if (c < b) {
            System.out.print(a);
            System.out.print(c);
            System.out.print(b);
        } else {
            System.out.print(a);
            System.out.print(b);
            System.out.print(c);
        }

        /*final ArrayList<Integer> list = new ArrayList<>(3);
        list.add(a);
        list.add(c);
        list.add(b);
        Collections.sort(list);
        System.out.println(list);*/
    }
}
