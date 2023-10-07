package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/9/12 9:23 星期二
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class T34_FindFirstAndLastIndexInOrderedArray {

    public int[] searchRange(int[] nums, int target) {
        //找到开始位置
        int left = leftMost(nums, target);
        //如果第一次都找不到，说明数组中根本不存在这个元素，直接返回[-1,-1]
        if (left == -1) {
            return new int[]{-1, -1};
        }
        //将开始位置作为左分界点，寻找结束位置
        return new int[]{left, rightMost(nums, target)};
    }

    /**
     * 找出target的开始位置
     * @param array 目标数组
     * @param target 目标值
     * @return 目标值所在的索引
     */
    public static int leftMost(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int candidate = -1;
        while (low <= high) {
            //无符号移位代替除法避免数据过大而出错
            int mid = (low + high) >>> 1;
            if (target < array[mid]) {
                high = mid - 1;
            } else if (target > array[mid]) {
                low = mid + 1;
            } else {
                candidate = mid;
                //缩小右分界点，继续尝试寻找比当前索引更靠左的索引
                high = mid - 1;
            }
        }
        return candidate;
    }

    /**
     * 找出target的结束位置
     * @param array 目标数组
     * @param target 目标值
     * @return 目标值所在的索引
     */
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
                //扩大左分界点，继续尝试寻找比当前索引更靠右的索引
                low = mid + 1;
            }
        }
        return candidate;
    }

}
