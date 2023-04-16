package test.oop;

import org.junit.jupiter.api.Test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @Author qzy
 * @ClassName Demo
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/1/29 22:04 星期日
 */
public class Demo {
    class A {
        int a = 10;
        private int b;

        public A() {
            b = 15;
        }

        public void show() {
            System.out.println("AAA");
        }

        void fun() {
            System.out.println("Father-FUN()");
        }
    }

    class B extends A {
        int a = 20;

        public B() {
            a = 21;
        }

        @Override
        public void show() {
            System.out.println("BBB");
        }

        private int c = 1;
        class C {
            void fun() {
                System.out.println(c);
            }
        }

        int fun(int a) {
            System.out.println("SON-FUN()");
            System.out.println(a);
            return a;
        }

        void fun(float a) {
            System.out.println("SON-FUN()");
            System.out.println(a);
        }

    }

    @Test
    void test() throws IOException {
        /*System.out.println(-10 % 3);
        System.out.println(-10 % -3);*/
        /*int a = 1;
        int b = 2;
        int c = 3;
        int d = a / b;
        int e = a / c;
        System.out.println(d);
        System.out.println(e);
        float f = (float) b / c;
        int g = (int) f;
        System.out.println(f);
        System.out.println(g);*/
        /*int one = 1;
        char two = '2';
        System.out.println((char) one);
        System.out.println((int) two);
        System.out.println((int) (one + two));
        System.out.println((char) (one + two));*/
        /*String test = "This is a test";
        String[] tokens = test.split("\\s");
        System.out.println(Arrays.toString(tokens));*/
        /*float f1 = 3.5555f;
        float f2 = 3.3335f;
        System.out.printf("%.0f,%.0f", f1, f2);*/
        /*double a[] = { 8.2, 3.8, 15.1, 9.0 };
        double max, min;
        max = min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            } else if (min > a[i]) {
                min = a[i];
            }
        }
        System.out.println(max);
        System.out.println(min);*/

    }


    @Test
    void testException() {
        int sel = 0;
        try {
            if (sel == 0) {
                System.out.println("no Exception ");
                return;
            } else if (sel == 1) {
                int i = 0;
                int j = 4 / i;
            }
        } catch (ArithmeticException e) {
            System.out.println("Catch ");
        } catch (Exception e) {
            System.out.println("Will not be executed");
        } finally {
            System.out.println("finally");
        }
    }

    @Test
    void testTransferLetter() {
        String s, s1 = "";
        char c;
        s = "wELCOME";
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                s1 = s1 + Character.toUpperCase(c);
            } else {
                s1 = s1 + Character.toLowerCase(c);
            }
        }
        System.out.println(s1);
    }

    @Test
    void testSwitch() {
        final Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        switch (score / 10) {
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
            case 7:
            case 6:
                System.out.println("B");
                break;
            default:
                System.out.println("C");
        }
    }

    @Test
    void test01() {
        final Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            try {
                num = scanner.nextInt();
                while (num < 0 || num > 10) {
                    System.out.println("数据不合法！");
                    num = scanner.nextInt();
                }
                System.out.println("数据合法：" + num);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        }
    }

    @Test
    void testSubStringCount() {
        String str = "abaabcababc";
        String sub = "abc";
        int count = 0;
        for (int i = 0, j = 0; i < str.length(); i++, j = i) {
            for (int k = 0; k < sub.length(); k++, j++) {
                if (sub.charAt(k) != str.charAt(j)) {
                    break;
                } else if (k == sub.length() - 1) {
                    count++;
                }
            }
        }
        System.out.println("count = " + count);
        /*String str = new Scanner(System.in).nextLine();
        int index = str.indexOf("aa"), count = 0;
        while (index != -1) {
            str = str.substring(index + 1);
            index = str.indexOf("aa");
            count++;
        }
        System.out.println("count = " + count);*/
    }

    @Test
    void testMaxMinExchangeHeadTrail() {
        int[] arr = {2, 0, 1, 4, 9, 7, 8};
        int min, max;
        min = max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
            if (arr[min] > arr[i]) {
                min = i;
            }
        }
        int temp = arr[0];
        arr[0] = arr[max];
        arr[max] = temp;

        temp = arr[arr.length - 1];
        arr[arr.length - 1] = arr[min];
        arr[min] = temp;
        System.out.println("arr = " + Arrays.toString(arr));
    }

    @Test
    void testInsertIntoSortedArray() {
        int[] arr = new int[6];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 5;
        arr[4] = 6;
        System.out.println("arr = " + Arrays.toString(arr));
        int insert = 4;
        int i;
        for (i = 0; i < arr.length; i++) {
            if (insert < arr[i]) {
                break;
            }
        }
        int j;
        for (j = arr.length - 1; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[j] = insert;
        System.out.println("arr = " + Arrays.toString(arr));
    }

    @Test
    void testMatrix_Type_X_Add() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int sum = -arr[arr.length / 2][arr.length / 2];
        System.out.println(sum);
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            sum += arr[i][i] + arr[i][j];
        }
        System.out.println("sum = " + sum);
    }

    @Test
    void testWordSort() {
        char[] chars = new Scanner(System.in).nextLine().toLowerCase().toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - 1 - i; j++) {
                if (chars[j] > chars[j + 1]) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        System.out.println(chars);
    }

    @Test
    void testMatrix_Type_X() {
        final int[][] array = new int[5][5];
        for (int i = 0, k = array.length - 1; i < array.length; i++, k--) {
            array[i][k] = 1;
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = 1;
                } else if (j != k) {
                    array[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

    }

    @Test
    void testSet() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(4);
        //交
        System.out.println("交：");
        for (Integer integer : set2) {
            if (set.contains(integer)) {
                System.out.print(integer);
            }
        }
        //并
        System.out.println("\n并：");
        set.addAll(set2);
        for (Integer integer : set) {
            System.out.print(integer);
        }
    }

    @Test
    void testPolygon() {
        final Polygon polygon = new Polygon(new int[]{1, 2, 3});
        polygon.print();
    }

    @Test
    void testPerson() {
        final Student student = new Student("qzy", '男', 20, "常州刘国钧高等职业技术学校", 5);
        student.showInfo();
        System.out.println(Math.PI);
    }

    @Test
    void testOuter() {
        final Outer outer = new Outer();
        outer.print();
    }

    @Test
    void testShape() {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2);
        shapes[1] = new Rectangle(2, 2);
        shapes[2] = new Triangle(3, 3, 4);
        for (Shape shape : shapes) {
            System.out.println(shape.area());
        }
    }
}