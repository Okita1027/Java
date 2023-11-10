package algorithm.sort;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/11/7 11:19 星期二
 * @title 归并+插入组合排序
 */
public class MergeInsertSort {
    public static void main(String[] args) {
        Integer[] ints = {3, 9, 2, 6, 5, 7, 1, 8, 4, 0};
        sort(ints);
        Arrays.stream(ints).forEach(System.out::print);
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
        //归并结合插入：在元素个数<=32时不再分治，而是采用直接插入排序
        if (high - low <= 32) {
            // 插入排序
            insertion(a, low, high);
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
