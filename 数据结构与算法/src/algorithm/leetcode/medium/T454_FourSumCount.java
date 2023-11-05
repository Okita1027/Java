package algorithm.leetcode.medium;

import java.util.HashMap;

/**
 * @author qzy
 * @time 2023/11/2 19:14 星期四
 * @title 454-四数相加
 */
public class T454_FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;  // 记录满足条件的元组个数
        int length = nums1.length;  // 数组的长度，假设四个数组的长度都相同
        HashMap<Integer, Integer> map = new HashMap<>();  // 存储两数组合的和以及出现次数的哈希表

        // 遍历nums1和nums2数组，计算所有可能的两数之和并存储到哈希表中
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // 遍历nums3和nums4数组，计算所有可能的两数之和，并在哈希表中查找其相反数的次数
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                count += map.getOrDefault(-nums3[i]-nums4[j], 0);
            }
        }

        return count;  // 返回满足条件的元组个数

    }
}
