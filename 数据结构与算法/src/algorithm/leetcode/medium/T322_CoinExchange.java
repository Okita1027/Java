package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/11/16 15:56 星期四
 * @title 零钱兑换
 */
public class T322_CoinExchange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        for (int i = 0, j = coins.length - 1; i < coins.length / 2; i++, j--) {
            int temp = coins[i];
            coins[i] = coins[j];
            coins[j] = temp;
        }
        int index = 0;
        int sum = 0;
        int count = 0;
        while (index < coins.length) {
            if (sum + coins[index] == amount) {
                sum += coins[index];
                count++;
                break;
            } else if (sum + coins[index] < amount) {
                count++;
                sum += coins[index];
            } else {
                index++;
            }
        }
        return sum == amount ? count : -1;
    }

}
