package algorithm.test;

import java.util.Arrays;

/**
 * @Author qzy
 * @ClassName InsertSort
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/25 13:44 星期二
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 0, 6, 2, 4, 5, 9, 8, 7};
        System.out.println("shellSort(array) = " + Arrays.toString(shellSort(array)));
    }

    public static int[] shellSort(int[] array) {
        int gap = 1;
        while (gap < array.length / 2) {
            gap = gap * 2 + 1;
        }
        while (gap >= 1) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (array[j] < array[j - gap]) {
                        int temp = array[j];
                        array[j] = array[j - gap];
                        array[j - gap] = temp;
                    } else {
                        break;
                    }
                }
            }
            gap /= 2;
        }
        return array;
    }
}
