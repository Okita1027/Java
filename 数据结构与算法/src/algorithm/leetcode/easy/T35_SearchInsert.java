package algorithm.leetcode.easy;

/**
 * @time 2023/9/12 9:19 星期二
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 */
public class T35_SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (target <= nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;  // key not found.
    }

    public static void main(String[] args) {
        T35_SearchInsert t35SearchInsert = new T35_SearchInsert();
        System.out.println(t35SearchInsert.searchInsert(new int[]{1,3,5,6}, 5));
    }
}
