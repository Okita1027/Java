package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/12/2 11:37 星期六
 * @title 81-搜索旋转排序数组II
 */
public class T81_SearchRotateSortedArrayII {
    public static void main(String[] args) {
        int[] array = {2, 5, 6, 0, 0, 1, 2};
        T81_SearchRotateSortedArrayII fun = new T81_SearchRotateSortedArrayII();
        boolean result = fun.search(array, 5);
        System.out.println("result1 = " + result);

        result = fun.search(array, 1);
        System.out.println("result2 = " + result);

        result = fun.search(array, 3);
        System.out.println("result3 = " + result);

    }
    /**
     * 在一个已经排好序的经过翻转N次后的数组中查找目标值
     * @param nums 给定的有序数组
     * @param target 目标值
     * @return 如果目标值存在于数组中，则返回true；否则返回false
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            //前半部分有序
            if (nums[left] < nums[mid]) {
                //目标值在前半部分
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {  //否则，在后半部分查找
                    left = mid + 1;
                }
            } else {
                //后半部分有序
                //目标值在后半部分
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {  //否则，在后半部分查找
                    right = mid - 1;
                }
            }
        }
        //一直没找到，返回false
        return false;
    }

}