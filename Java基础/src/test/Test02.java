package test;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName Test02
 * @Description 第二章
 * @Date 2022/12/26 14:24 星期一
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            System.out.println("number.charAt(i) = " + number.charAt(i));
            sum += Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        System.out.println("sum = " + sum);


    }

    @Test
    void test01() {
        //计算2的三次方
        System.out.println(Math.pow(2, 3));

        float f = 12.3f;
        double d = 23.4d;
        System.out.println(f % 5);
        System.out.println(d % 5);

        d = 12.3d;
        System.out.println(d > f);//false

        System.out.printf("%25f", 1.1 / 1000000000000000000L);
    }

    @Test
    void test02() throws IOException {

    }

}
