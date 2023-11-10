package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qzy
 * @time 2023/11/2 17:44 星期四
 * @title 18-四数之和
 */
public class T18_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;  // 数组长度小于4，直接返回空列表
        }

        Arrays.sort(nums);  // 对数组进行排序，方便后续操作

        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;  // 跳过重复的元素，避免重复计算相同的四元组
            }

            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;  // 当最小的四个数之和大于目标值时，退出循环，因为已排序数组后面的数更大
            }

            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;  // 当最大的四个数之和小于目标值时，跳过当前循环
            }

            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;  // 跳过重复的元素，避免重复计算相同的四元组
                }

                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;  // 当最小的四个数之和大于目标值时，退出循环
                }

                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;  // 当最大的四个数之和小于目标值时，跳过当前循环
                }

                int left = j + 1, right = length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {  // 当四个数的和等于目标值时，找到一个满足条件的四元组
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;  // 跳过重复的元素
                        }
                        left++;  // 移动左指针
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;  // 跳过重复的元素
                        }
                        right--;  // 移动右指针
                    } else if (sum < target) {
                        left++;  // 四个数的和小于目标值，左指针右移
                    } else {
                        right--;  // 四个数的和大于目标值，右指针左移
                    }
                }
            }
        }

        return quadruplets;  // 返回结果列表
    }
}
