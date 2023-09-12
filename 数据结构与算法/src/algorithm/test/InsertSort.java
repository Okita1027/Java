package algorithm.test;

import java.util.Arrays;

/**
 * @Author qzy
 * @ClassName InsertSort
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/25 13:44 星期二
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 2, 4, 5, 9, 8, 7};
        System.out.println("insertSort(array) = " + Arrays.toString(insertSort(array)));

        int[] array2 = {1, 3, 6, 2, 4, 5, 9, 8, 7};
        System.out.println("insertSort2(array2) = " + Arrays.toString(insertSort2(array2)));
    }

    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insert = array[i];
            int index = i - 1;
            while (index >= 0 && insert < array[index]) {
                array[index + 1] = array[index];
                array[index] = insert;
                index--;
            }
        }
        return array;
    }

    public static int[] insertSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return array;
    }
}
