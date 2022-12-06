package algorithm.leetcode.easy;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName T1480
 * @Description 一维数组的动态和
 * @Date 2022/6/19 7:43 星期日
 * 给你一个数组 nums ,请返回 nums 的动态和。
 * 数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) ,
 * 示例 3：
 *  输入：nums = [3,1,2,10,1]
 *  输出：[3,4,6,16,17]
 */
public class T1480 {
    public int[] runningSum(int[] nums) {
        int[] array = new int[nums.length];
        array[0] = nums[0];
        int sum = array[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            array[i] = sum;
        }
        return array;
    }
}
