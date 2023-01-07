package test.book.two;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName Exercise
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/1/7 17:33 星期六
 */
public class Exercise {
    public static void main(String[] args) {
        System.out.print("Enter the time zone offset to GMT : ");
        Scanner input = new Scanner(System.in);

        //时区偏移量
        int ZoneOffset = input.nextInt();
        //总毫秒数
        long totalMilliseconds = System.currentTimeMillis();
        //总秒数
        long totalSeconds = totalMilliseconds / 1000;
        //当前秒数
        long currentSecond = totalSeconds % 60;
        //总分钟数
        long totalMinutes = totalSeconds / 60;
        //当前分钟数
        long currentMinute = totalMinutes % 60;
        //总小时数
        long totalHours = totalMinutes / 60;
        //当前小时数
        long currentHour = (totalHours % 24 + ZoneOffset + 24) % 24;

        System.out.println("The current time is " + currentHour + ":" + currentMinute + ":" + currentSecond);
    }
    @Test
    void test27() {
        int a = 1000000000 / 60 / 24;
        System.out.println(a / 365);
        System.out.println(a % 365);
    }

    @Test
    void name() {
        final LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.atOffset(ZoneOffset.ofHours(8)));
    }

}
