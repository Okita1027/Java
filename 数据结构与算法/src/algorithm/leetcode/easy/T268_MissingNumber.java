package algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/12/6 8:44 星期三
 * @title 丢失的数字
 */
public class T268_MissingNumber {
    /**
     * 找出缺失的数字
     * @param nums 整数数组
     * @return 缺失的数字
     */
    public int missingNumber(int[] nums) {
        // 对数组进行排序
        Arrays.sort(nums);
        int res = nums.length;

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果当前索引 i 不等于数组中的元素 nums[i]，说明缺失了数字
            if (i != nums[i]) {
                // 将缺失的数字赋值给结果变量 res
                res = i;
                // 跳出循环
                break;
            }
        }

        // 返回结果变量 res，即缺失的数字
        return res;
    }


}
