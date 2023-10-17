package algorithm.sort;

import datastructure.heap.MaxHeap;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/10/14 14:19 星期六
 * @title 堆排序
 * 算法描述：
 * 1、heapify建立大顶堆
 * 2、将堆顶与堆底元素交换（最大元素被交换达到堆底），缩小并下潜调整堆
 * 3、重复第二步直到堆中只剩下一个个元素
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 7, 4, 0, 3, 9, 6, 8};
        System.out.println("没有排序->array = " + Arrays.toString(array));
        heapSort(array);
        System.out.println("排序后->array = " + Arrays.toString(array));
    }

    private static int size;
    public static void heapSort(int[] array) {
/*        MaxHeap heap = new MaxHeap(array);
        while (heap.size > 1) {
            swap(heap.array, 0, heap.size - 1);
            heap.size--;
            heap.sink(0);
        }*/
        size = array.length;
        heapify(array);
        System.out.println("转换为大顶堆->array = " + Arrays.toString(array));
        while (size > 1) {
            swap(array, 0, size - 1);
            size--;
            sink(array, 0);
        }
    }

    private static void heapify(int[] source) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            sink(source, i);
        }
    }

    private static void sink(int[] array, int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        if (max != parent) {
            swap(array, max, parent);
            sink(array, max);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
