package algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qzy
 * @time 2023/11/7 16:13 星期二
 * @title 基数排序
 * 基数排序（Radix Sort）是一种非比较性的排序算法，它根据元素的位数来进行排序。通常用于整数或字符串的排序。
 * <p>
 * 具体步骤如下：
 * <p>
 * 按照个位、十位、百位等位数顺序，依次对待排序数组进行稳定的排序（一般使用计数排序或桶排序）。
 * 每次排序完成后，将数组按照当前位上的数值排列顺序重新排列。
 * 重复上述步骤，直到对最高位排序完成。
 * 基数排序的时间复杂度取决于位数和每位的排序算法的时间复杂度。在最坏情况下，基数排序的时间复杂度为 O(n*k)，其中 n 为待排序元素的数量，k 为数字的最大位数。
 * 需要注意的是，基数排序只适用于正整数或者可以转换为正整数的数据类型，对于负数和小数需要进行特殊处理。
 *
 * 基数排序的优点是稳定性好，适用于数字位数较小的情况，且不受待排序元素大小的影响。但需要注意的是，基数排序需要额外的空间来存储中间结果，因此在数据量较大的情况下可能会消耗较多的内存。
 */

public class RadixSort {
    public static void radixSort(int[] array) {
        if (array.length == 0) {
            return; // 如果数组为空，直接返回
        }

        // 寻找数组中的最大值
        int maxValue = array[0];
        for (int value : array) {
            if (value > maxValue) {
                maxValue = value; // 更新最大值
            }
        }

        // 计算最大值的位数
        int maxDigit = 0;
        while (maxValue > 0) {
            maxValue /= 10;
            maxDigit++;
        }

        // 初始化桶
        List<List<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>()); // 创建 10 个桶
        }

        // 进行排序
        for (int digit = 1; digit <= maxDigit; digit++) {
            // 将元素分配到桶中
            for (int value : array) {
                int bucketIndex = (value / (int)Math.pow(10, digit - 1)) % 10; // 确定元素所属的桶的索引
                buckets.get(bucketIndex).add(value); // 将元素加入对应的桶中
            }

            // 从桶中取出元素并更新原数组
            int currentIndex = 0;
            for (List<Integer> bucket : buckets) {
                for (int value : bucket) {
                    array[currentIndex++] = value; // 更新原数组
                }
                bucket.clear(); // 清空桶
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {8, 13, 7, 329, 457, 657, 839, 436, 720, 355, 22, 11, 9};
        radixSort(array); // 使用基数排序对数组进行排序

        System.out.println("排序后的数组：");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}

