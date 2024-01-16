package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/12/2 13:25 星期六
 * @title 寻找旋转排序数组中的最小值
 */
public class T153_FindMinInRotatedSortedArray {

    public int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果中间元素大于最右边元素，说明最小值在右半部分
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // 如果中间元素小于等于最右边元素，说明最小值在左半部分
                right = mid;
            }
        }
        // 最小值在[left, right]范围内，返回left对应的元素
        return nums[left];
    }

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