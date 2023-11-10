package algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author qzy
 * @time 2023/11/7 15:48 星期二
 * @title 桶排序
 * 将待排序元素分散到不同的“桶”中，然后分别对每个桶中的元素进行排序，最后将各个桶中的元素合并得到有序序列。
 * <p>
 * 具体步骤如下：
 * <p>
 * 创建一个定量的空桶数组，并确定每个桶的范围，这个范围需要根据待排序元素的分布情况来合理设置。
 * 遍历待排序数组，根据元素的值将元素放入对应的桶中。
 * 分别对每个非空桶进行排序，可以选择其他排序算法，也可以递归使用桶排序。
 * 将各个桶中的元素按照顺序合并成最终的排序结果。
 * 桶排序的时间复杂度取决于对各个非空桶进行排序的时间复杂度。在最坏情况下，如果所有元素都落在同一个桶中，桶排序的时间复杂度会退化为 O(nlogn)。但在平均情况下，桶排序的时间复杂度是线性的，即 O(n+k)，其中 n 为待排序元素的数量，k 为桶的数量。
 *
 * 桶排序适用于待排序元素均匀分布在一个范围内的情况，它能够充分利用计算机内存空间的特点，因此在某些场景下有较好的排序性能。但需要注意的是，桶排序需要额外的空间来存储桶，所以在数据量较大的情况下，可能会消耗较多的内存。
 */
public class BucketSort {
    /**
     * 桶排序
     * @param array 原数组
     * @param bucketSize 单个桶的大小
     */
    public static void bucketSort(int[] array, int bucketSize) {
        if (array.length == 0) {
            return; // 如果数组为空，直接返回
        }

        // 寻找数组中的最大值和最小值
        int minValue = array[0];
        int maxValue = array[0];
        for (int value : array) {
            if (value < minValue) {
                minValue = value; // 更新最小值
            } else if (value > maxValue) {
                maxValue = value; // 更新最大值
            }
        }

        // 初始化桶
        int bucketCount = (maxValue - minValue) / bucketSize + 1; // 确定桶的数量
        List<List<Integer>> buckets = new ArrayList<>(bucketCount); // 创建桶的列表
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>()); // 每个桶初始化为空
        }

        // 将元素分配到桶中
        for (int value : array) {
            int bucketIndex = (value - minValue) / bucketSize; // 确定元素所属的桶的索引
            buckets.get(bucketIndex).add(value); // 将元素加入对应的桶中
        }

        // 对每个桶内部进行排序，并合并结果
        int currentIndex = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket); // 对每个非空桶进行排序
            for (int value : bucket) {
                array[currentIndex++] = value; // 合并排序后的桶内元素
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {0, 29, 25, 3, 49, 9, 37, 21, 43, 11, 56, -2, -11};
        bucketSort(array, 10);

        System.out.println("排序后的数组：");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
