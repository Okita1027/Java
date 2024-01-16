package algorithm.leetcode.medium;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author qzy
 * @time 2023/12/7 13:58 星期四
 * @title 数组中的第K个最大元素
 */
public class T215_FindKthLargest {
    public static void main(String[] args) {
        int[] array = {2, 1, 3, 5, 6, 0, 7, 8};
        T215_FindKthLargest fun = new T215_FindKthLargest();
        fun.quickInsertSort(array);
        System.out.println("array = " + Arrays.toString(array));
    }
    public int findKthLargest(int[] nums, int k) {
        quickInsertSort(nums);
        return nums[nums.length - k];
    }

    /**
     * 对数组进行快速插入排序
     * @param nums 待排序的数组
     */
    private void quickInsertSort(int[] nums) {
        quickInsertSort(nums, 0, nums.length - 1);
    }

    /**
     * 使用快速排序和插入排序结合的方式对数组的指定范围进行排序
     * @param nums 待排序的数组
     * @param low 排序范围的左边界
     * @param high 排序范围的右边界
     */
    private void quickInsertSort(int[] nums, int low, int high) {
        // 当待排序部分长度小于等于32时，使用插入排序
        if (high - low <= 32) {
            insertion(nums, low, high);
            return;
        }
        // 使用快速排序找到分区点并递归排序
        int partition = partition(nums, low, high);
        quickInsertSort(nums, low, partition - 1);
        quickInsertSort(nums, partition + 1, high);
    }

    /**
     * 使用快速排序找到分区点
     * @param nums 待排序的数组
     * @param low 分区范围的左边界
     * @param high 分区范围的右边界
     * @return 分区点的索引
     */
    private int partition(int[] nums, int low, int high) {
        // 随机选择分区点的索引并交换到待排序部分的起始位置
        int idx = ThreadLocalRandom.current().nextInt(high - low + 1) + low;
        swap(nums, idx, low);
        int key = nums[low]; // 选取第一个元素作为分区关键值
        int left = low, right = high + 1; // 初始化左右指针
        // 进行分区操作
        while (true) {
            while (nums[--right] > key) { // 从右向左找到第一个小于关键值的元素
                if (right == low) {
                    break;
                }
            }
            while (nums[++left] < key) { // 从左向右找到第一个大于关键值的元素
                if (left == high) {
                    break;
                }
            }
            if (left >= right) { // 左右指针相遇时结束分区操作
                break;
            } else {
                swap(nums, left, right); // 交换左右指针所指元素
            }
        }
        swap(nums, low, right); // 将关键值交换到分区点
        return right; // 返回分区点的索引
    }

    /**
     * 使用插入排序对数组的指定范围进行排序
     * @param nums 待排序的数组
     * @param left 排序范围的左边界（包含）
     * @param right 排序范围的右边界（包含）
     */
    private void insertion(int[] nums, int left, int right) {
        for (int low = left + 1; low <= right; low++) {
            int key = nums[low]; // 保存当前待插入的元素
            int index = low - 1; // 初始化已排序部分的最后一个元素的索引
            // 将当前元素与已排序部分进行比较并插入到合适位置
            while (index >= left && key < nums[index]) {
                nums[index + 1] = nums[index]; // 将大于待插入元素的元素后移一位
                index--; // 继续向前搜索合适的插入位置
            }
            // 将待插入元素插入到合适位置
            if (index != low - 1) {
                nums[index + 1] = key;
            }
        }
    }

    /**
     * 使用位运算交换数组中两个元素的值
     * @param nums 数组
     * @param i 要交换的元素下标
     * @param j 要交换的元素下标
     */
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }


}
