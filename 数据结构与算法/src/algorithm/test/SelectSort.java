package algorithm.test;

import java.util.Arrays;

/**
 * @Author qzy
 * @ClassName SelectSort
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/25 11:32 星期二
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 2, 4, 5, 9, 8, 7};
        System.out.println(Arrays.toString(selectSort(array)));
    }

    public static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
}
