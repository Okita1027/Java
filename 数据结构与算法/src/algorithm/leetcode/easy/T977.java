package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/9/18 14:58 星期一
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 */
public class T977 {
    public int[] sortedSquares(int[] nums) {
        int[] array = new int[nums.length];
        int i = array.length - 1;
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int leftValue = Math.abs(nums[left]);
            int rightValue = Math.abs(nums[right]);
            if (leftValue > rightValue) {
                array[i--] = leftValue * leftValue;
                left++;
            } else {
                array[i--] = rightValue * rightValue;
                right--;
            }
        }
        return array;
    }

    public static void main(String[] args) {

    }
}
