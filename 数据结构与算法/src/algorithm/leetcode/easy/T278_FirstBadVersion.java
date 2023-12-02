package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/12/1 9:51 星期五
 * @title 278-第一个错误的版本
 */
public class T278_FirstBadVersion {
    // 递归
    public int firstBadVersion(int n) {
        int i = 1, j = n;
        while (i <= j) {
            // 向下取整除法计算中点 m
            int m = i + (j - i) / 2;
            // 若 m 是错误版本，则最后一个正确版本一定在闭区间 [i, m - 1]
            if (isBadVersion(m)) {
                j = m - 1;
            } else {
                // 若 m 是正确版本，则首个错误版本一定在闭区间 [m + 1, j]
                i = m + 1;
            }
        }
        // i 指向首个错误版本，j 指向最后一个正确版本
        return i;
    }

    // 迭代
    public int firstBadVersion0(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }



    // 题目给的API,大类继承了这个子类中的方法用于在题目使用
    boolean isBadVersion(int version) {
        return true;
    }

}
