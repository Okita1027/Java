package algorithm.sort;

import java.util.Arrays;

/**
 * @time 2022/5/30 21:14 星期一
 * 分治思想->归并排序
 * 1.尽可能将一组数据拆分成两个元素相等的子组，并对每一个子组继续拆分，直到拆分后的每个子组的元素个数是1为止。
 * 2.将相邻的两个子组进行合并成一个有序的大组；
 * 3.不断重复步骤2，直到最终只有一个组为止。
 */
@SuppressWarnings("all")
public class MergeSort {
    public static void main(String[] args) {
        Integer[] ints = {3, 6, 5, 7, 1, 8, 4, 0};
        sort(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }

    //辅助数组
    private static Comparable[] assist;

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //对数组a中的元素进行排序
    public static void sort(Comparable[] a) {
        //记录原始数组
        assist = new Comparable[a.length];
        //记录数组的最小和最大索引
        int low = 0;
        int high = a.length - 1;
        //利用sort重载方法完成数组a中，索引low到high的元素的排序
        sort(a, low, high);
    }

    //对数组a中从low到high的元素进行排序
    private static void sort(Comparable[] a, int low, int high) {
        //安全检验：在分组到数组只剩下一个元素时停止分组
        if (high <= low) {
            return;
        }
        //对low到high之间的数据分为2个组
        //int mid = (low + high) / 2;   //数值过大可能超出int存储范围
        int mid = low + (high - low) / 2;
        //对两组数据分别进行排序
        sort(a, low, mid);
        sort(a, mid + 1, high);
        //归并排序
        merge(a, low, mid, high);
    }

    //从low到mid为一组；从mid+1到high为一组分别进行归并排序
    private static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int p1 = low;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= high) {
            if (less(a[p1], a[p2])) {
                assist[i++] = a[p1++];
            } else {
                assist[i++] = a[p2++];
            }
        }
        while (p1 <= mid) {
            assist[i++] = a[p1++];
        }
        while (p2 <= high) {
            assist[i++] = a[p2++];
        }

        System.arraycopy(assist, low, a, low, high + 1 - low);
    }

}
