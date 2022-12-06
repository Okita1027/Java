package algorithm.sort;

import java.util.Arrays;

/**
 * @time 2022/5/29 14:48 星期日
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] ints = {1, 4, 6, 7, 8, 2, 3, 5, 0};
        selectSort(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }

    public static void selectSort(int[] array) {
        int miniIndex;
        for (int i = 0; i < array.length; i++) {
            //刚开始默认数组第一个元素是最小的
            miniIndex = i;
            //j = i + 1; 表示i之前的数已经排列完毕了
            for (int j = i + 1; j < array.length; j++) {
                //记录后续更小的值的下标
                if (array[miniIndex] > array[j]) {
                    miniIndex = j;
                }
            }
			if (miniIndex != i) {
				int temp = array[i];
                array[i] = array[miniIndex];
                array[miniIndex] = temp;
			}
        }
    }
}
