package datastructure.heap;

/**
 * @time 2022/6/5 20:08 星期日
 * 最大优先队列：使用堆实现，在普通队列先进先出的基础上
 * 实现每次取出的对头元素总是最大的
 * 与Heap不同的仅仅是多了个isEmpty、size方法
 */
public class MaxPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int size;

    public MaxPriorityQueue(int maxCapacity) {
        this.items = (T[]) new Comparable[maxCapacity + 1];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    public void exchange(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void insert(T value) {
        items[++size] = value;
        swim(size);
    }

    private void swim(int k) {
        while (k > 1) {
            if (less(k / 2, k)) {
                exchange(k / 2, k);
            }
            k /= 2;
        }
    }

    public T remove() {
        T value = items[1];
        exchange(1, size);
        items[size--] = null;
        sink();
        return value;
    }

    private void sink() {
        int k = 1;
        while (2 * k <= size) {
            int max;
            if (2 * k + 1 <= size) {
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            } else {
                max = 2 * k;
            }
            if (!less(k, max)) {
                break;
            }
            exchange(k, max);
            k = max;
        }
    }
}
