package algorithm.leetcode.medium;

import java.util.*;

/**
 * @author qzy
 * @time 2023/11/16 9:26 星期四
 * @title 518-零钱兑换II
 */
public class T518_CoinExchangeII {

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        for (int i = 0, j = coins.length - 1; i < coins.length / 2; i++, j--) {
            int temp = coins[i];
            coins[i] = coins[j];
            coins[j] = temp;
        }
        return exchange(0, coins, amount);
    }

    private int exchange(int index, int[] coins, int remainder) {
        if (remainder == 0) {
            return 1;
        } else if (remainder < 0) {
            return 0;
        } else {
            int count = 0;
            for (int i = index; i < coins.length; i++) {
                count += exchange(i, coins, remainder - coins[i]);
            }
            return count;
        }
    }
}
