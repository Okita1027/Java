package algorithm.sort;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/11/7 14:48 星期二
 * @title 计数排序
 * 要点
 * 1．找到最大值，创建一个大小为最大值+1的count数组
 * 2. count数组的索引对应原始数组的元素，用来统计该元素的出现次数
 * 3．遍历 count数组，根据 count 数组的索引(即原始数组的元素)以及出现次数，生成排序后内容
 *    count数组的索引是:已排序好的
 *
 * 前提条件:待排序元素>=0;且最大值不能太大
 */
public class CountSort {
    public static void main(String[] args) {
        int[] ints = {-2, -9, -1, 3, 6, 1, 8, 4, 7, 0, 5, 2, -5, 9, -7};
        countSort(ints);
        System.out.println(Arrays.toString(ints));
    }
    public static void countSort(int[] array) {
        /*
            找到最大值、最小值
         */
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            } else if (min > array[i]) {
                min = array[i];
            }
        }
        /* 创建计数用的数组 */
        int[] count = new int[max - min + 1];
        /*
            计数, 最小的元素（即使是负数）从0开始计数
         */
        for (int value : array) {
            count[value - min]++;
        }
        /*
            排序，覆盖原数组
         */
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[idx++] = i + min;
                count[i]--;
            }
        }
    }
}
