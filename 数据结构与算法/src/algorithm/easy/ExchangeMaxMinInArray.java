package algorithm.easy;

import java.util.Arrays;

/**
 * @Author qzy
 * @ClassName ExchangeMaxMinInArray
 * @Description 交换 最大/小数 和 0/末位
 * @Date 2023/2/4 21:01 星期六
 */
public class ExchangeMaxMinInArray {
    public static void main(String[] args) {
        int[] array = {3, 4, 1, 0, 5, 7, 6, 9, 2};
        int max, min;
        max = min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[max] < array[i]) {
                max = i;
            } else if (array[min] > array[i]) {
                min = i;
            }
        }
        if (max != 0) {
            int temp = array[max];
            array[max] = array[0];
            array[0] = temp;
        }
        if (min != array.length - 1) {
            int temp = array[min];
            array[min] = array[array.length - 1];
            array[array.length - 1] = temp;
        }
        System.out.println("array = " + Arrays.toString(array));
    }
}
