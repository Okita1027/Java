package algorithm.recursion;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/9/14 11:37 星期四
 * 插入排序（递归）
 */
public class InsertSort {

    public static void insertSort(int[] array) {
        insertion(array, 1);
    }

    private static void insertion(int[] array, int low) {
        if (low == array.length) {
            return;
        }
        int temp = array[low];
        int i = low - 1;    //已排序区域指针

        while (i >= 0 && array[i] > temp) { // 没有找到插入位置
            array[i + 1] = array[i]; // 空出插入位置
            i--;
        }

        //找到插入位置
        if (i + 1 != low) {
            array[i + 1] = temp;
        }

        insertion(array, low + 1);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2, 4, 5, 1, 3};
        insertSort(ints);
        System.out.println("ints = " + Arrays.toString(ints));
    }
}
