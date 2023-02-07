package test.program;


import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        //排序三个数
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (a > b) {
            int temp = a;
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
        }

    }

    @Test
    void test00() {
        final int[] arr = new int[1000];
        final int[] count = new int[21];
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            arr[i] = (int) (Math.random() * 20 + 0.5);
        }
        /*ArrayList<Integer> arrayList = new ArrayList();
        for (int k : arr) {
            arrayList.add(k);
        }
        Collections.sort(arrayList);
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
        }
        System.out.println();*/
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 1000; j++) {
                if (arr[j] == i) {
                    count[i]++;
                }
            }
            sum += count[i];
        }
        System.out.println(sum);
    }

    @Test
    void test01() {
        //使用循环计算1+1/2+1/3+1/4+...前20项的和
        int i = 1;
        int sum = 0;
        while (i <= 20) {
            sum += 1 / i++;
        }
        System.out.println("sum = " + sum);
    }

    @Test
    void test02() {
        //有一分数序列：2/1,3/2,5/3,8/5,13/8,21/13...,求出前20项之和
        double[] mother = new double[22];
        double[] son = new double[22];
        mother[0] = 2;
        mother[1] = 3;
        son[0] = 1;
        son[1] = 2;
        double sum = 0;
        for (int i = 0; i < 20; i++) {
            sum += mother[i] / son[i];
            mother[i + 2] = mother[i] + mother[i + 1];
            son[i + 2] = son[i] + son[i + 1];
        }
        System.out.println("sum = " + sum);
    }

    @Test
    void factorial() {
        //递归求5！
        System.out.println(fun(5));
    }

    int fun(int num) {
        if (num == 1) {
            return 1;
        }
        return num * fun(num - 1);
    }

    @Test
    void people5() {
        //有5个人坐在一起，问第五个人多少岁，说比第四个人大2岁...，第一个人10岁
        System.out.println(age(5));
    }

    int age(int num) {
        if (num == 1) {
            return 10;
        }
        return age(num - 1) + 2;
    }

    @Test
    void test03() {
        //判断星期几
        final Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        switch (s.charAt(0)) {
            case 'M':
                System.out.println("Monday");
                break;
            case 'T':
                if (s.charAt(1) == 'u') {
                    System.out.println("Tuesday");
                    break;
                }
                System.out.println("Thursday");
                break;
            case 'W':
                System.out.println("Wednesday");
                break;
            case 'F':
                System.out.println("Friday");
                break;
            case 'S':
                if (s.charAt(1) == 'a') {
                    System.out.println("Saturday");
                    break;
                }
                System.out.println("Sunday");
        }
    }

    @Test
    void test04() {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k < 5; k++) {
                    if (i != j && j != k) {
                        System.out.print(i * 100 + j * 10 + k + "\t");
                    }
                }
            }
            System.out.println();
        }
    }

    @Test
    void test05() {
        int iron = 2000;
        int count = 0;
        while (iron >= 5) {
            iron /= 2;
            count++;
        }
        System.out.println("count = " + count);
    }

    @Test
    void test06() {
        int count = 0;
        int mother = 1;
        double num = 0;
        double target = 3.14159;
        while (4 * num < target) {
            if (count++ % 2 == 0) {
                num += 1.0 / mother;
            } else {
                num -= 1.0 / mother;
            }
            mother += 2;
        }
        System.out.println(count);
    }

    @Test
    void test07() {
        //解决Junit不能控制台输入的方法：Help -> Custom VM Option -> add "-Deditable.java.test.console=true -> 重启IDEA"
        String[] day = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        System.out.println(day[new Scanner(System.in).nextInt() - 1]);
    }

    @Test
    void test08() {
        //打印矩形
        final int width = new Scanner(System.in).nextInt();
        final int height = new Scanner(System.in).nextInt();
        //输出第一排
        for (int i = 0; i < width; i++) {
            System.out.print("* ");
        }
        System.out.println();
        //输出中间排
        for (int i = 0; i < height - 2; i++) {
            System.out.print("*");
            for (int j = 0; j < width - 2; j++) {
                System.out.print("  ");
            }
            System.out.println(" *");
        }
        //输出最后一排
        for (int i = 0; i < width; i++) {
            System.out.print("* ");
        }
    }

}

