package algorithm.dynamic_programming;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author qzy
 * @time 2023/11/18 14:51 星期六
 * @title LeetCode322-零钱兑换
 */
public class ChangeExchange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[][] dp = new int[coins.length][amount + 1];
        for (int j = 1; j < amount + 1; j++) {
            if (j >= coins[0]) {
                dp[0][j] = 1 + dp[0][j - coins[0]];
            } else {
                dp[0][j] = max;
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            print(dp);
        }
        int r = dp[coins.length - 1][amount];
        return r > amount ? -1 : r;
    }

    public static void main(String[] args) {
        ChangeExchange leetcode = new
                ChangeExchange();
        int count = leetcode.coinChange(new int[]{1, 2, 5}, 5);
        // int count = leetcode.coinChange(new int[]{25, 10, 5, 1}, 41);
        // int count = leetcode.coinChange(new int[]{2}, 3);
        // int count = leetcode.coinChange(new int[]{15, 10, 1}, 21);
        System.out.println(count);
    }

    static void print(int[][] dp) {
        System.out.println("-".repeat(18));
        Object[] array = IntStream.range(0, dp[0].length + 1).boxed().toArray();
        System.out.printf(("%2d ".repeat(dp[0].length)) + "%n", array);
        for (int[] d : dp) {
            array = Arrays.stream(d).boxed().toArray();
            System.out.printf(("%2d ".repeat(d.length)) + "%n", array);
        }
    }

    // 降维
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j < amount + 1; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
            }
        }
        int r = dp[amount];
        return r > amount ? -1 : r;
    }
}
