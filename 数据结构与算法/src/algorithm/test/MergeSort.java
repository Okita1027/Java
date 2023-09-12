package algorithm.test;

import java.util.Arrays;

/**
 * @Author qzy
 * @ClassName MergeSort
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/25 14:37 星期二
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 2, 4, 5, 9, 8, 7};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static int[] assist;

    private static void mergeSort(int[] array) {
        assist = new int[array.length];
        int low = 0;
        int high = array.length - 1;
        mergeSort(array, low, high);
    }

    private static void mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(array, 0, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int p1 = low;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= high) {
            if (array[p1] < array[p2]) {
                assist[i++] = array[p1++];
            } else {
                assist[i++] = array[p2++];
            }
        }
        while (p1 <= mid) {
            assist[i++] = array[p1++];
        }
        while (p2 <= high) {
            assist[i++] = array[p2++];
        }
        System.arraycopy(assist, low, array, low, high + 1 - low);
    }
}
