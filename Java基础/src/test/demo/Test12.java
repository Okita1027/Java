package test.demo;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName Test12
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/1/4 21:33 星期三
 */
public class Test12 {
    @Test
    public void test01() {
        try {
            Circle circle1 = new Circle(1);
            Circle circle2 = new Circle(-1);
        } catch (IllegalArgumentException e) {
            try {
                e.printStackTrace();
                throw new NullPointerException("null");
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Circle.num = " + Circle.num);
    }

    @Test
    public void test02() {
        class A {
            int a;
            void method() {
                System.out.println("a = " + a++);
            }
        }
        A a = new A();
        a.method();
    }

    private class Circle {
        private double radius;
        private static int num;

        public Circle(double radius) {
            setRadius(radius);
            num++;
        }

        public void setRadius(double radius) throws IllegalArgumentException {
            if (radius >= 0) {
                this.radius = radius;
            } else {
                throw new IllegalArgumentException("can't be negative");
            }

        }
    }

    @Test
    void test03() {
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            /*
                Java在处理表达式计算时，默认对整数型0转型成0.0，而浮点数在计算机内是无法绝对精确的表示的，
                因此这个0.0在计算机内部只是一个接近0的极小浮点值而已，所以很容易的可以想出为什么输出Infinity。
                同样的取模运算%也存在这个问题。
             */
            System.out.println(1.0 / 0);
        }
        long value = Long.MAX_VALUE + 1;
        System.out.println(value);//溢出-9223372036854775808
    }

    @Test
    void test04() {
        try {
            String s = "abc";
            System.out.println(s.charAt(3));
        } catch (Exception exception) {
            System.out.println("exception.toString() = " + exception);
            System.out.println("...");
        }
        System.out.println("Test12.test04");
        try {
            Object o = new Object();
            String d = (String) o;
        } catch (Exception e) {
            System.out.println("e = " + e);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testFile() throws IOException {
        File fire = new File("src/test/fire.txt");
        if (!fire.exists()) {
            fire.createNewFile();
            PrintWriter printWriter = new PrintWriter(fire);
            printWriter.write("hhh");
            printWriter.println(123);
            printWriter.close();
        }
        //try with resource -> 自动关闭资源
        try (BufferedReader reader = new BufferedReader(new FileReader(fire))) {
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println("str = " + str);
            }
        }

        fire.delete();
    }

    @Test
    void test05() {
        System.out.print("---");
        System.out.printf("%5s", true);
        System.out.println("---");
    }

    @Test
    void testURL() throws IOException {
        URL url = new URL("https://www.baidu.com");
        InputStream inputStream = url.openStream();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            byte[] bytes = bufferedInputStream.readAllBytes();
            System.out.println("bytes = " + bytes.length);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        double d = scanner.nextDouble();
        String s = scanner.nextLine();
        System.out.print(i);
        System.out.print(d);
        System.out.print(s);
    }

}
