package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/10/12 8:24 星期四
 * @title 189->轮转数组
 */
public class T189_RotateArrayTwoSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        T189_RotateArrayTwoSum fun = new T189_RotateArrayTwoSum();
        fun.rotate(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));

        nums = new int[]{1};
        k = 1;
        fun.rotate(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));

        nums = new int[]{-1};
        k = 2;
        fun.rotate(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));

        nums = new int[]{1, 2};
        k = 3;
        fun.rotate(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));

        nums = new int[]{1, 2, 3, 4, 5, 6};
        k = 11;
        fun.rotate(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));

        nums = new int[]{1, 2};
        k = 5;
        fun.rotate(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate2(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));

        nums = new int[]{1};
        k = 1;
        rotate2(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));

        nums = new int[]{-1};
        k = 2;
        rotate2(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));

        nums = new int[]{1, 2};
        k = 3;
        rotate2(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));

        nums = new int[]{1, 2, 3, 4, 5, 6};
        k = 11;
        rotate2(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));

        nums = new int[]{1, 2};
        k = 5;
        rotate2(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate3(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));

        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        k = 4;
        rotate3(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));

        nums = new int[]{1, 2, 3, 4, 5, 6};
        k = 3;
        rotate3(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));

        nums = new int[]{1, 2, 3, 4, 5, 6};
        k = 11;
        rotate3(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        // 削减多余的次数
        while (k >= nums.length) {
            k -= nums.length;
        }
        int left = 0;
        int right = nums.length - k;
        // 每次从(开头++)将元素往后移动array.length-1位
        // 每次将最后一个元素放到开头
        for (int i = 0; i < k; i++) {
            int temp = nums[right];
            System.arraycopy(nums, left, nums, left + 1, (nums.length - k));
            nums[left] = temp;
            left++;
            right++;
        }
    }

    public void rotate2(int[] nums, int k) {
        if (nums.length == 1 || k == nums.length) {
            return;
        }
        while (k > nums.length) {
            k -= nums.length;
        }
        int[] array = new int[nums.length];
        int i, j;
        // 把数组末尾将要转移至数组开头的元素放到新数组中
        for (i = 0, j = nums.length - k; j < nums.length; j++) {
            array[i++] = nums[j];
        }
        j = 0;
        // 把不需要转移的元素放入新数组
        while (i < array.length) {
            array[i++] = nums[j++];
        }
        // 覆盖原数组的内容
        System.arraycopy(array, 0, nums, 0, array.length);
    }

    public void rotate3(int[] nums, int k) {
        if (nums.length == 1 || k == nums.length) {
            return;
        }
        while (k > nums.length) {
            k %= nums.length;
        }
        int backup = nums[k];
        int left = 0;
        int mid = k;
        int right = nums.length - k;
        for (int i = 0; i < k; i++) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[mid] = temp;

            left++;
            mid++;
            right++;
        }
        nums[nums.length - 1] = backup;
    }
}
