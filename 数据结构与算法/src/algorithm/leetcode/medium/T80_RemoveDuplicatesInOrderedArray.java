package algorithm.leetcode.medium;

import algorithm.leetcode.easy.T88_MergeTwoOrderedArrays;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/10/7 15:23 星期六
 * @title
 */
public class T80_RemoveDuplicatesInOrderedArray {
    public int removeDuplicates(int[] nums) {
        //∵数组长度>=1∴计数器和右指针从1开始;length辅助控制循环次数
        int left = 0, right = 1, count = 1, length = nums.length;
        while (right < length) {
            //值相等的情况：
            if (nums[left] == nums[right]) {
                if (left + 1 == right) {
                    //左右指针相邻：计数器+1、右指针后移
                    right++;
                    count++;
                } else {
                    //将右指针后1个开始的元素覆盖到当前位置
                    System.arraycopy(nums, right + 1, nums, right, nums.length - right - 1);
                    //不比较末尾2个覆盖的元素->循环次数-1
                    length--;
                }
            } else {
                //值不等的情况：
                //双指针后移，计数器+1
                left++;
                right++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3};
        T80_RemoveDuplicatesInOrderedArray fun = new T80_RemoveDuplicatesInOrderedArray();
        int count = fun.removeDuplicates(array);
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
