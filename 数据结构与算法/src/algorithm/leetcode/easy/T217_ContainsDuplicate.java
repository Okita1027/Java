package algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author qzy
 * @time 2023/11/5 16:41 星期日
 * @title 217-存在重复元素
 */
public class T217_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            if (count == 1) {
                return true;
            }
            map.put(num, count + 1);
        }
        return false;
    }
}
