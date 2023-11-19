package algorithm.divide_conquer;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author qzy
 * @time 2023/11/19 12:41 星期日
 * @title 快速查找
 */
public class QuickSelection {
    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 100);
        }
        int index = 4;
        System.out.println("第" + index + "大的元素是：" + quickSelect(nums, index));
        Arrays.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public static int quickSelect(int[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1);
    }

    private static int quickSelect(int[] nums, int k, int left, int right) {
        int p = partition(nums, 0, nums.length - 1);
        if (p == k) {
            return nums[p];
        } else if (p < k) {
            return quickSelect(nums, k, p + 1, nums.length - 1);
        } else {
            return quickSelect(nums, k, 0, p - 1);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(nums, left, idx);
        int pv = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && nums[i] < pv) {
                i++;
            }
            while (i <= j && nums[j] > pv) {
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
