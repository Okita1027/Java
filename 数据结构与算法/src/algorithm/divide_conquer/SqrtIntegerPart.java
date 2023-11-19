package algorithm.divide_conquer;

/**
 * @author qzy
 * @time 2023/11/19 15:00 星期日
 * @title LeetCode 69 平方根的整数部分
 */
public class SqrtIntegerPart {
    // 求取一个数的平方根
    public int mySqrt(int num) {
        int left = 1, right = num;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            // 如果num除以mid大于等于mid
            if (num / mid >= mid) {
                result = mid; // 更新结果为mid
                left = mid + 1; // 更新左边界为mid的下一个数
            } else {
                right = mid - 1; // 更新右边界为mid的上一个数
            }
        }
        return result; // 返回结果
    }

}
