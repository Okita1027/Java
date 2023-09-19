package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author qzy
 * @time 2023/9/18 16:21 星期一
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class T209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left, right;
        int result = Integer.MAX_VALUE;
        for (left = right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                int subLength = right - left + 1;
                result = Math.min(subLength, result);
                sum -= nums[left++];
            }
        }
        if (left == 0 && right == nums.length) {
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2, 3, 1, 2, 4, 3};
        int max = new T209().minSubArrayLen(7, ints);
        System.out.println("max = " + max);
    }
}
