package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/11/30 10:45 星期四
 * @title 2的幂次方
 */
public class T231_Pow2 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        // 位运算判断是否为奇数
        if ((n & 1) != 0) {
            return false;
        }
        return isPowerOfTwo(n >> 1);
    }
}
