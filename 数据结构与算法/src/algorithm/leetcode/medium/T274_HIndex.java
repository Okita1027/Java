package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/12/6 8:37 星期三
 * @title H指数
 */
public class T274_HIndex {
    public int hIndex(int[] citations) {
        // 对数组进行排序
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;

        // 从后往前遍历数组
        for (int i = 0; i < n; i++) {
            // 计算当前的 H 指数，取当前引用次数和剩余未遍历的论文数中的较小值
            // 即 Math.min(citations[i], n - i)
            // 然后将其与当前 H 指数 h 中的较大值进行比较，更新 H 指数 h
            h = Math.max(h, Math.min(citations[i], n - i));
        }

        // 返回得到的 H 指数 h
        return h;
    }
}
