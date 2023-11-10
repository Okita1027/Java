package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/11/10 17:14 星期五
 * @title 164-最大间距-中等
 */
public class T164_MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int res = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            int gap = nums[i] - nums[i - 1];
            if (gap > res) {
                res = gap;
            }
        }
        return res;
    }
}
