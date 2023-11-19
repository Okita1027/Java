package algorithm.divide_conquer;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/11/18 16:02 星期六
 * @title 快速选择
 */
public class QuickSelect {
    public static void main(String[] args) {
        // 生成随机数数组
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 100);
        }
        int k = 4;
        System.out.println("第" + k + "大的元素是：" + quickSelect(nums, k));
        Arrays.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    /**
     * 选择排序算法，找到数组中第k小的元素
     * @param nums  待排序的数组
     * @param k  第k小的元素
     * @return  第k小的元素
     */
    public static int quickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    /**
     * 选择排序算法的递归实现，找到数组中第k小的元素
     * @param nums  待排序的数组
     * @param left  数组的左边界
     * @param right  数组的右边界
     * @param k  第k小的元素
     * @return  第k小的元素
     */
    public static int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[(left + right) / 2];  // 选择数组的中间位置元素作为基准值
        int i = left, j = right;  // 定义两个指针分别指向数组的左右边界
        while (i <= j) {  // 循环直到指针i大于指针j
            while (nums[i] < pivot) i++;  // 在左边界与基准值之间找到第一个大于基准值的元素
            while (nums[j] > pivot) j--;  // 在右边界与基准值之间找到第一个小于基准值的元素
            if (i <= j) {  // 如果指针i小于等于指针j
                int temp = nums[i];  // 交换两个元素的位置
                nums[i] = nums[j];
                nums[j] = temp;
                i++;  // 指针i向右移动
                j--;  // 指针j向左移动
            }
        }
        if (left <= k - 1 && k - 1 <= j) {  // 如果第k小的元素在指针i的右边，则递归调用quickSelect(nums, left, j, k)
            return quickSelect(nums, left, j, k);
        }
        if (i <= k - 1 && k - 1 <= right) {  // 如果第k小的元素在指针i的左边，则递归调用quickSelect(nums, i, right, k)
            return quickSelect(nums, i, right, k);
        }
        return nums[k - 1];  // 返回第k小的元素
    }

}
