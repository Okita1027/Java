package algorithm.sort;

import java.util.Arrays;

/**
 * @Author qzy
 * @ClassName BlobSort
 * @Description 冒泡排序
 * @Date 2022/11/23 16:02 星期三
 */
public class BlobSort {
    public static void main(String[] args) {
        Integer[] array = {8, 7, 4, 9, 1, 5, 6, 0, 3, 2};
        blobSort(array);
        System.out.println("array = " + Arrays.toString(array));
    }

    public static void blobSort(Comparable[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    Comparable temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
