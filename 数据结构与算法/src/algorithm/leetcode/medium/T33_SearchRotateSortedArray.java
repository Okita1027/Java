package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/12/1 10:21 星期五
 * @title 搜索旋转排序数组
 */
public class T33_SearchRotateSortedArray {
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        T33_SearchRotateSortedArray fun = new T33_SearchRotateSortedArray();
        int result = fun.search(array, 4);
        System.out.println("result = " + result);

        array = new int[]{4, 5, 6, 7, 0, 1, 2};
        result = fun.search(array, 3);
        System.out.println("result = " + result);

        array = new int[]{1};
        result = fun.search(array, 1);
        System.out.println("result = " + result);

        array = new int[]{1, 3};
        result = fun.search(array, 3);
        System.out.println("result = " + result);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[right]) {
                // 左半部分有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右半部分有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
