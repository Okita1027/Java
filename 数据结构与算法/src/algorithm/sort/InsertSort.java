package algorithm.sort;

import java.util.Arrays;

/**
 * @time 2022/5/29 15:24 星期日
 * 插入排序：从第二个数开始当做待插入的数字与前面的数字比较，
 * 如果比前面小，就与前面一个数交换位置，
 * 再和前面的数比较直到这个待插入的数比前面的数大。
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] ints = {3, 6, 1, 4, 0, 2, 9, 7, 5};
        insertSort(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }

    public static void insertSort(int[] array) {
        //不需要和自己比较，所以从1开始
        for (int i = 1; i < array.length; i++) {
            int key = array[i];//待插入的元素
            int index = i - 1;//待比较的元素下标，从待插入的元素左边开始比较
            //若左边还有待比较元素并且待插入的值小于待比较的值
            //就交换两者的值，并把待比较的元素下标左移一位
            while (index >= 0 && key < array[index]) {
                array[index + 1] = array[index];
                array[index] = key;
                index--;
            }
        }
    }
}
