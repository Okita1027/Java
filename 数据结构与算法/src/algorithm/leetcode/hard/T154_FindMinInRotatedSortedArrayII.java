package algorithm.leetcode.hard;

/**
 * @author qzy
 * @time 2023/12/8 20:25 星期五
 * @title 寻找旋转排序数组中的最小值II
 */
public class T154_FindMinInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2; // 中间位置
            if (nums[mid] > nums[right]) { // 最小值在右半部分
                left = mid + 1;
            } else if (nums[mid] < nums[right]) { // 最小值在左半部分
                right = mid;
            } else { // 无法判断最小值在哪一部分
                right--;
            }
        }
        return nums[left]; // 返回最小值
    }
}
