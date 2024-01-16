package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/12/7 9:47 星期四
 * @title 最接近的三数之和
 */
public class T16_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // 初始最接近的三数之和
        int minDifference = Math.abs(closestSum - target); // 初始差值的绝对值

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int difference = Math.abs(sum - target);

                if (difference < minDifference) {
                    minDifference = difference; // 更新最小差值
                    closestSum = sum; // 更新最接近的三数之和
                }

                if (sum < target) {
                    left++; // 和较小，移动左指针增大和
                } else if (sum > target) {
                    right--; // 和较大，移动右指针减小和
                } else {
                    return sum; // 和等于目标值，直接返回和
                }
            }
        }

        return closestSum;
    }
}
