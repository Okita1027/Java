package test.book.one;

import org.junit.jupiter.api.Test;

/**
 * @Author qzy
 * @ClassName Exercise
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/1/7 16:01 星期六
 */
public class Exercise {
    @Test
    void test14() {
       /* System.out.println("a\t\ta^2\t\ta^3");
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 4; j++) {
                System.out.printf("%.0f\t\t", Math.pow(i, j));
            }
            System.out.println();
        }*/
        String head1="a";
        String head2="a^2";
        String head3="a^3";

        System.out.printf("%-7s%-7s%-7s%n", head1, head2, head3);

        for(int i=1; i<5; i++)
            System.out.printf("%-7d%-7d%-7d%n",i, i * i, i * i * i);
    }

    @Test
    void test15() {
        System.out.println((9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5));
    }

    @Test
    void test16() {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }

    @Test
    void test110() {
        double hour = (45 * 60 + 30) / 3600;
        System.out.println(14 / 1.6 / hour);
    }
}
