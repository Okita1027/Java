package algorithm.sort;

import java.util.Arrays;

/**
 * @time 2022/5/29 20:25 星期日
 * 希尔排序：是插入排序的一种，又称“缩小增量排序”，是插入排序算法的一种更高效的改进版本。
 * 1.选定一个增长量gap，按照增长量gap作为数据分组的依据，对数据进行分组；
 * 2.对分好组的每一组数据完成插入排序；
 * 3.减小增长量，最小减为1，重复第二步操作
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] ints = {1, 3, 6, 2, 5, 4, 9, 7, 0, 8};
        shellSort(ints);
        Arrays.stream(ints).forEach(System.out::print);
        ints = new int[]{32, 17, 98, 36, 56, 41, 162, 25, 131, 239, 0, 143};
        shellSort(ints);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public static void shellSort(int[] array) {
        //增量是分组的依据
        int gap = 1;
        //初始化增量公式
        while (gap < array.length / 2) {
            gap = gap * 2 + 1;
        }
        //以增量为依据进行分组排序
        //增量=1时，就相当于直接插入排序
        while (gap >= 1) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (array[j] < array[j - gap]) {
                        int temp = array[j];
                        array[j] = array[j - gap];
                        array[j - gap] = temp;
                    } else {//之前的序列已经有序，不用再进行比较了
                        break;
                    }
                }
            }
            //逐步缩小增量
            gap /= 2;
        }
    }

}
