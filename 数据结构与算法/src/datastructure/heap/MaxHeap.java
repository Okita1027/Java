package datastructure.heap;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/10/14 11:17 星期六
 * @title 大顶堆 -> heapify、sink、floating方法是重点
 * 堆可以认为是优先级队列
 */
public class MaxHeap {
    public int[] array;
    public int size;

    public MaxHeap(int[] source) {
        this.array = source;
        size = source.length;
        heapify();
    }

    /**
     * 建堆
     */
    private void heapify() {
        // i -> 最后一个非叶子节点
        // 公式 -> size / 2 - 1
        for (int i = size / 2 - 1; i >= 0; i--) {
            sink(i);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    /**
     * 添加元素
     * @param offered 新元素
     * @return 是否添加成功
     */
    public boolean offer(int offered) {
        if (isFull()) {
            return false;
        }
        floating(offered);
        size++;
        return true;
    }

    /**
     * 获取堆顶元素
     * @return 堆顶元素
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("堆空！");
        }
        return array[0];
    }

    /**
     * 移除堆顶元素
     * @return 堆顶元素
     */
    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("堆空！");
        }
        int removed = array[0];
        swap(0, size - 1);
        size--;
        sink(0);
        return removed;
    }

    /**
     * 移除指定位置的元素
     * @param index 索引
     * @return 被移除元素
     */
    public int poll(int index) {
        if (isEmpty()) {
            throw new RuntimeException("堆空！");
        } else if (index >= size) {
            throw new RuntimeException("该索引不合法！");
        }
        int removed = array[index];
        swap(index, size - 1);
        size--;
        sink(index);
        return removed;
    }

    /**
     * 替换堆顶元素
     * @param replaced 替换值
     */
    public void replace(int replaced) {
        array[0] = replaced;
        sink(0);
    }

    /**
     * 下沉元素
     * @param parent 父节点
     * 为了给HeapSort.java使用，这个修饰符改成了public
     */
    public void sink(int parent) {
        // 找到左子节点和右子节点的索引
        int left = parent * 2 + 1;
        int right = left + 1;
        // 默认父节点比子节点大
        int max = parent;
        /*
            比较父节点与2个子节点之间的值大小
         */
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        if (max != parent) {
            // 交换父节点和2个子节点中较大的一方
            swap(max, parent);
            // 继续比较下2个子节点
            sink(max);
        }
    }

    /**
     * 上浮
     * @param offered 新元素
     */
    private void floating(int offered) {
        // 将要添加的元素的下标就是size
        int child = size;
        while (child > 0) {
            // 父节点计算公式 -> (child - 1) / 2
            int parent = (child - 1) / 2;
            if (array[child] > array[parent]) {
                // 父节点向下覆盖
                array[child] = array[parent];
                //子节点索引变为父节点继续向上比较
                child = parent;
            } else {
                break;
            }
        }
        // 位置调整完毕，在堆中加入新元素
        array[child] = offered;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
