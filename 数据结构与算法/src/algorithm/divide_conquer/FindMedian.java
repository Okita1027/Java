package algorithm.divide_conquer;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author qzy
 * @time 2023/11/19 11:16 星期日
 * @title 寻找中位数
 */
public class FindMedian {
    public static void main(String[] args) {
        // 偶数位数
        System.out.println(findMedian(new int[]{3, 1, 5, 4}));
        System.out.println(findMedian(new int[]{3, 1, 5, 4, 7, 8}));
        // 奇数位数
        System.out.println(findMedian(new int[]{4, 5, 1}));
        System.out.println(findMedian(new int[]{4, 5, 1, 6, 3}));
    }

    /**
     * 寻找中位数
     * @param nums 原数组
     * @return 中位数
     */
    public static double findMedian(int[] nums) {
        if (nums.length % 2 == 1) { // 奇数
            return findMedian(nums, nums.length / 2);
        } else {    // 偶数
            int x = findMedian(nums, nums.length / 2);
            int y = findMedian(nums, nums.length / 2 - 1);
            return (double) (x + y) / 2;
        }
    }

    private static int findMedian(int[] nums, int index) {
        return findMedian(nums, 0, nums.length - 1, index);
    }

    private static int findMedian(int[] nums, int left, int right, int index) {
        int partition = partition(nums, 0, nums.length - 1, index);
        if (partition == index) {
            return nums[partition];
        } else if (partition < index) {
            return findMedian(nums, partition + 1, right, index);
        } else {
            return findMedian(nums, 0, partition - 1, index);
        }
    }

    private static int partition(int[] nums, int left, int right, int index) {
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(nums, left, idx);
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, left, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
