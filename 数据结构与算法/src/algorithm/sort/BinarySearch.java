package algorithm.sort;

import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * @date 2022/6/7 10:33 星期二
 * 二分查找：前提条件是查找的数组是有序的
 * 暴力查找时间复杂度：O(N)；二分查找时间复杂度：O(log(N))
 */
public class BinarySearch {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static int binarySearch(Comparable[] array, Comparable value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            //每次从中间开始查找
            int mid = (low + high) / 2;
            //找到了则直接返回元素下标
            if (array[mid] == value) {
                return mid;
            }
            //若没找到，判断当前值与目标值的大小
            //若当前值大，则将查找的最大范围缩小一半
            //若当前值小，则将查找的最小范围扩大一半
            if (less(value, array[mid])) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        //没找到返回-1
        return -1;
    }

    /**
     * 平衡版
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length;

        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (target < array[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (target == array[left]) {
            return target;
        } else {
            return -1;
        }
    }

    /**
     * 二分查找——LeftMost
     * @param array 待查找的升序数组
     * @param target 目标值
     * @return >= target 的最靠左索引
     */
    public static int binarySearchIndex(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target <= array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(array, 3));
    }

}
