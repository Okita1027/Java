package algorithm.dynamic_programming;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/11/18 10:22 星期六
 * @title 背包问题
 *      1. n个物品都是固体，有重量和价值
 *      2. 现在你要取走不超过 10克 的物品
 *      3. 每次可以不拿或全拿，问最高价值是多少
 *      编号 重量(g) 价值(元) 简称
 *      1 4 1600 黄金一块 400 A
 *      2 8 2400 红宝石一粒 300 R
 *      3 5 30 白银一块 S
 *      0 1 1_000_000 钻石一粒 D
 *      1_001_630
 *      1_002_400
 */
public class KnapsackProblem {
    static class Item {
        int index;
        String name;
        int weight;
        int value;
        public Item(int index, String name, int weight, int value) {
            this.index = index;
            this.name = name;
            this.weight = weight;
            this.value = value;
        }
        @Override
        public String toString() {
            return "Item(" + name + ")";
        }
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(1, "黄金", 4, 1600),
                new Item(2, "宝石", 8, 2400),
                new Item(3, "白银", 5, 30),
                new Item(4, "钻石", 1, 10_000),
        };
        System.out.println(select(items, 10));
    }

    static int select(Item[] items, int total) {
        Item item0 = items[0];
        int[][] dp = new int[items.length][total + 1];
        for (int j = 0; j < total + 1; j++) {
            if (item0.weight <= j) {
                dp[0][j] = item0.value;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            Item item = items[i];
            for (int j = 1; j < total + 1; j++) {
                // x:上一次同容量背包的最大价值
                int x = dp[i - 1][j];
                if (j >= item.weight) {
                    // j - item.weight:当前背包容量 - 这次物品重量 = 剩余背包空间
                    // y: 剩余背包空间能装下的最大价值 + 这次物品价值
                    int y = dp[i - 1][j - item.weight] + item.value;
                    dp[i][j] = Math.max(x, y);
                } else {
                    dp[i][j] = x;
                }
            }
        }
        return 0;
    }

    // 降维
    static int select1(Item[] items, int total) {
        int[] dp = new int[total + 1];
        for (Item item : items) {
            for (int j = total; j > 0; j--) {
                if (j >= item.weight) { // 装得下
                    dp[j] = Integer.max(dp[j], item.value + dp[j - item.weight]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[total];
    }
}
