package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/11/17 17:07 星期五
 * @title 不同路径
 */
public class T61_UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        // 直走右边或直走下边的路径均为1
        for (int i = 0; i < m; i++) {
            path[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            path[0][i] = 1;
        }
        // 机器人斜对角的路径等同于去这个角的左边和上边的路径之和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n, int rubbish) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            dp[0] = 1;
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
