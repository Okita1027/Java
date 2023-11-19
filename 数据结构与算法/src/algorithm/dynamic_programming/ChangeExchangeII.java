package algorithm.dynamic_programming;

/**
 * @author qzy
 * @time 2023/11/18 15:18 星期六
 * @title 零钱兑换II
 */
public class ChangeExchangeII {
    public int change(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j < amount + 1; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        ChangeExchangeII leetcode = new
                ChangeExchangeII();
        int count = leetcode.change(new int[]{1, 2, 5}, 5);
        System.out.println(count);
    }
}
