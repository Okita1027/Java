package algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/12/6 9:00 星期三
 * @title 多数元素
 */
public class T169_MajorityElement {
    public int majorityElement(int[] nums) {
        // 排序
        Arrays.sort(nums);
        // 取中位数
        return nums[nums.length / 2];
    }

    // 摩尔投票法
    public int majorityElementM(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            // 当计数器归零时，将当前元素设为候选元素
            if (count == 0) {
                candidate = num;
            }
            // 根据当前元素是否与候选元素相等来增加或减少计数器
            count += (num == candidate) ? 1 : -1;
        }

        // 最终留下的候选元素就是数组中的多数元素
        return candidate;
    }
}
