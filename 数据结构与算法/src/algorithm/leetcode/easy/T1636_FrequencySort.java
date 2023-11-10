package algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author qzy
 * @time 2023/11/10 15:46 星期五
 * @title 1636-按照频率将数组升序排序
 * 提示：
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class T1636_FrequencySort {
    public static void main(String[] args) {
        int[] array = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        T1636_FrequencySort fun = new T1636_FrequencySort();
        System.out.println("fun.frequencySort(array) = " + Arrays.toString(fun.frequencySort(array)));
    }

    public int[] frequencySort(int[] nums) {
        // 计算数组的最大、最小值便于后续决定count数组的长度
        int minValue = nums[0];
        int maxValue = nums[0];
        for (int num : nums) {
            if (minValue > num) {
                minValue = num;
            } else if (maxValue < num) {
                maxValue = num;
            }
        }
        int[] count = new int[maxValue - minValue + 1];
        for (int num : nums) {
            // 最小的负数从0开始计数
            count[num - minValue]++;
        }
        int finalMinValue = minValue;
        // 根据数字出现的频率排序
        return Arrays.stream(nums).boxed().sorted((o1, o2) -> {
            int a = count[o1 - finalMinValue];
            int b = count[o2 - finalMinValue];
            // 频率不同：按照频率排序
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            } else {
                // 频率一样：按照元素本身值进行排序
                return o2 - o1;
            }
        }).mapToInt(Integer::intValue).toArray();
    }

    public int[] frequencySort1(int[] nums) {
        int[] count = new int[201];
        for (int num : nums) {
            count[num + 100]++;
        }
        return Arrays.stream(nums).boxed().sorted((a, b) -> {
            int af = count[a + 100];
            int bf = count[b + 100];
            if (af < bf) {
                return -1;
            } else if (af > bf) {
                return 1;
            } else {
                return b - a;
            }
        }).mapToInt(Integer::intValue).toArray();
    }
}
