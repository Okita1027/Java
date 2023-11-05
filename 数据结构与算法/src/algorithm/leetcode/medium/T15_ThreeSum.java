package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author qzy
 * @time 2023/11/2 16:28 星期四
 * @title 15-三数之和
 */
public class T15_ThreeSum {
    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(array);
        System.out.println("new T15_ThreeSum().threeSum(array) = " + new T15_ThreeSum().threeSum(array));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            // 因为 nums[right] >= nums[left] >= nums[k] > 0，即 333 个元素都大于 000 ，在此固定指针 k 之后不可能再找到结果了。
            if (nums[k] > 0)
                break;
            // 已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
            if (k > 0 && nums[k] == nums[k - 1])
                continue;
            int left = k + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (sum < 0) {  // s < 0时，left += 1并跳过所有重复的nums[left]；
                    while (left < right && nums[left] == nums[++left]) ;
                } else if (sum > 0) {   // s > 0时，right -= 1并跳过所有重复的nums[right]；
                    while (left < right && nums[right] == nums[--right]) ;
                } else {    // s == 0时，记录组合[k, left, right]至res，执行i += 1和j -= 1并跳过所有重复的nums[left]和nums[right]，防止记录到重复组合。
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[++left]) ;
                    while (left < right && nums[right] == nums[--right]) ;
                }
            }
        }
        return res;
    }
}
