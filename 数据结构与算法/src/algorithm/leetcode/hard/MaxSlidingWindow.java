package algorithm.leetcode.hard;

import java.util.*;

/**
 * @author qzy
 * @time 2023/9/25 10:19 星期一
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.push(nums[i]);
            } else {
                result[j++] = queue.stream().max((num1, num2) -> num1 - num2).get();
                queue.push(nums[i]);
                queue.pop();
            }
        }
        result[result.length - 1] = queue.stream().max(Comparator.comparingInt(num -> num)).get();
        return result;
    }

    public static void main(String[] args) {
        int[] result = new MaxSlidingWindow().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println("result = " + Arrays.toString(result));

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        

    }
}
