package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/9/12 9:23 星期二
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class T34 {

    public int[] searchRange(int[] nums, int target) {
        int left = leftMost(nums, target);
        if (left == -1) {
            return new int[]{-1,-1};
        }
        return new int[]{left, rightMost(nums, target)};
    }

    public static int leftMost(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int candidate = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (target < array[mid]) {
                high = mid - 1;
            } else if (target > array[mid]) {
                low = mid + 1;
            } else {
                candidate = mid;
                high = mid - 1;
            }
        }
        return candidate;
    }

    public static int rightMost(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int candidate = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (target < array[mid]) {
                high = mid - 1;
            } else if (target > array[mid]) {
                low = mid + 1;
            } else {
                candidate = mid;
                low = mid + 1;
            }
        }
        return candidate;
    }

}
