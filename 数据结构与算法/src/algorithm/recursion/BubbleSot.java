package algorithm.recursion;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/9/14 11:29 星期四
 * 冒泡排序（递归）
 */
public class BubbleSot {
    public static void bubbleSort(int[] array) {
        fun(array, array.length - 1);
    }

    private static void fun(int[] array, int right) {
        if (right == 0) {
            return;
        }
        int x = 0;  //记录从哪里开始已经排好序了
        for (int i = 0; i < right; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                x = i;  //下标i右边已经排好序了
            }
        }
        fun(array, x);
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 3, 1, 4};
        bubbleSort(array);
        System.out.println("array = " + Arrays.toString(array));
    }
}
