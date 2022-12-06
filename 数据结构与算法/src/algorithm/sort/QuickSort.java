package algorithm.sort;

import java.util.Arrays;

/**
 * @time 2022年5月11日11:12:55
 * 快速排序：与归并排序一样基于分治思想，是冒泡排序的改进版本
 * 1.首先设定一个分界值，通过该分界值将数组分成左右两部分；
 * 2.将大于或等于分界值的数据放到到数组右边，小于分界值的数据放到数组的左边。此时左边部分中各元素都小于
 * 或等于分界值，而右边部分中各元素都大于或等于分界值；
 * 3.然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两
 * 部分，同样在左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理。
 * 4.重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。当
 * 左侧和右侧两个部分的数据排完序后，整个数组的排序也就完成了。
 */
public class QuickSort {
    public static void main(String[] args) {
        Integer[] ints = {3, 6, 1, 8, 4, 7, 0, 5, 2, 9};
        quickSort(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }

    public static boolean less( Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exchange(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quickSort(Comparable array[])
    {
        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);
    }

    private static void quickSort(Comparable array[], int low, int high)
    {
        if (high <= low) {
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
        //切分值为数组的第一个元素
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
}
