package algorithm.test;

import java.util.Arrays;

/**
 * @Author qzy
 * @ClassName QuickSort
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/25 15:00 星期二
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 2, 4, 5, 9, 8, 7};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array) {
        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);


    }

    private static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int partition = partition(array, low, high);
        quickSort(array, low, partition - 1);
        quickSort(array, partition + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int key = array[low];
        int left = low;
        int right = high + 1;
        while (true) {
            while (key < array[--right]) {
                if (right == low) {
                    break;
                }
            }
            while (key > array[++left]) {
                if (left == high) {
                    break;
                }
            }
            if (left >= right) {
                break;
            } else {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        int temp = array[low];
        array[low] = array[right];
        array[right] = temp;
        return right;
    }
}
