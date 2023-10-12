package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/9/15 19:41 星期五
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * 示例 1：
 *
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * 示例 2:
 *
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 */
public class T485_MaxNumberOfConsecutive1 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[] count = new int[nums.length];
        /*
          将nums数组中每段连续1的个数记录在count数组中
         */
        for (int i = 0, index = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count[index]++;
            } else {
                index++;
            }
        }
        /*
            从count数组中找出最大连续1的值
         */
        int max = count[0];
        for (int i = 1; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 1, 1, 0, 1};
        System.out.println(new T485_MaxNumberOfConsecutive1().findMaxConsecutiveOnes(array));
    }
}
