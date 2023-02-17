package test.oop;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

/**
 * @Author qzy
 * @ClassName Demo
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/1/29 22:04 星期日
 */
public class Demo {

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