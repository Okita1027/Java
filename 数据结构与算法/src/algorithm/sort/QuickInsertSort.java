package algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author qzy
 * @time 2023/11/7 14:19 星期二
 * @title 快排+插入
 */
public class QuickInsertSort {
    public static void main(String[] args) {
        Integer[] ints = {3, 6, 1, 8, 4, 7, 0, 5, 2, 9};
        quickSort(ints);
        Arrays.stream(ints).forEach(System.out::print);
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exchange(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quickSort(Comparable array[]) {
        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);
    }

    private static void quickSort(Comparable array[], int low, int high) {
        // 剩余元素不足32个时，使用直接插入排序
        if (high - low <= 32) {
            insertion(array, low, high);
            return;
        }
        //找出用于切分的下标
        int partition = partition(array, low, high);
        //根据切分的下标对左边、右边的数组分别进行递归排序
        //切分值本身不参与排序过程
        quickSort(array, low, partition - 1);
        quickSort(array, partition + 1, high);
    }

    private static int partition(Comparable[] array, int low, int high) {

        // 使用随机的切分值
        int idx = ThreadLocalRandom.current().nextInt(high - low + 1) + low;
        exchange(array, low, idx);

        //切分值为数组的第一个元素 -> 可能遇到极端情况使时间复杂度变为O(n²),所以用到上面2行代码
        Comparable key = array[low];

        //定义两个指针分别指向数组最左边元素的前一个位置和最右边元素的后一个位置
        //切分值本身不参与排序所以left = low;
        int left = low;
        int right = high + 1;
        while (true) {
            //指针从右开始往左找比分界值小的元素
            while (less(key, array[--right])) {
                if (right == low) {
                    break;
                }
            }
            //指针从左开始往右找比分界值大的元素
            while (less(array[++left], key)) {
                if (left == high) {
                    break;
                }
            }
            //若两个while循环有一个没有找到比分界值大/小的元素
            //则表示该数组已有序，退出整个循环
            if (left >= right) {
                break;
            } else {//否则交换左右两边的值
                exchange(array, left, right);
            }
        }
        //在整个循环结束之后还需要将分界值放在有序数组中合适的位置
        exchange(array, low, right);
        //返回分界值
        return right;
    }

    private static void insertion(Comparable[] a, int left, int right) {
        for (int low = left + 1; low <= right; low++) {
            Comparable t = a[low];
            int i = low - 1;
            while (i >= left && less(t, a[i])) {
                a[i + 1] = a[i];
                i--;
            }
            if (i != low - 1) {
                a[i + 1] = t;
            }
        }
    }
}
