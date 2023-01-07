package test.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

/**
 * @Author qzy
 * @ClassName Test04
 * @Description 第四章
 * @Date 2022/12/27 17:21 星期二
 */
public class Test04 {
    public static void main(String[] args) {
        System.out.println("\\");
        System.out.println("\"");
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println((int)'0');
        System.out.println((char) (int)(Math.random() * 26 + 'a'));
        System.out.println((int) (Math.random() * 26));

        float f = 12.34f;
        System.out.printf("%.3f\n", f);
        System.out.printf("%4.2f\n", f);
        System.out.printf("%f\n", f);

        System.out.printf("%-6b%s\n", (1 > 2), "Java");
        System.out.printf("%6b%-8s\n", (1 > 2), "Java");
        System.out.printf("%,5d %,6.1f\n", 312342, 315562.932);
        System.out.printf("%05d %06.1f\n", 32, 32.32);
    }

    @Test
    @DisplayName("数学函数")
    void testMath() {
        System.out.println("Math.E = " + Math.E);
        System.out.println("Math.PI = " + Math.PI);
        System.out.println("Math.exp(2) = " + Math.exp(2));
        System.out.println("Math.log(8) = " + Math.log(8));
        System.out.println("Math.log10(100) = " + Math.log10(100));
        System.out.println("Math.pow(3,3) = " + Math.pow(3, 3));
        System.out.println("Math.sqrt(16) = " + Math.sqrt(16));
        System.out.println("Math.abs(-1) = " + Math.abs(-1));
        System.out.println("Math.floor(1.5) = " + Math.floor(1.6));
        System.out.println("Math.ceil(1.5) = " + Math.ceil(1.4));
        System.out.println("Math.rint(2.5) = " + Math.rint(2.5));
        System.out.println("Math.rint(2.4) = " + Math.rint(2.4));
        System.out.println("Math.rint(-2.4) = " + Math.rint(-2.4));
        System.out.println("Math.rint(-2.5) = " + Math.rint(-2.5));
        System.out.println("Math.round(1.4) = " + Math.round(1.4));
        System.out.println("Math.round(1.5) = " + Math.round(1.5));
        System.out.println("Math.round(-1.5) = " + Math.round(-1.5));
        System.out.println("Math.round(-1.6) = " + Math.round(-1.6));
    }

    @Test
    void testTime() {
        //获得系统的时间，单位为毫秒,转换为妙
        long totalMilliSeconds = System.currentTimeMillis();
        long totalSeconds = totalMilliSeconds / 1000;
        //求出现在的秒
        long currentSecond = totalSeconds % 60;
        //求出现在的分
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        //求出现在的小时
        long totalHour = totalMinutes / 60;
        long currentHour = totalHour % 24;
        //显示时间
        System.out.println("总毫秒为： " + totalMilliSeconds);
        System.out.println(currentHour + ":" + currentMinute + ":" + currentSecond + " GMT");

        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());
    }

}
