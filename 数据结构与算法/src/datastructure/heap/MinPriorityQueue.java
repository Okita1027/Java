package datastructure.heap;

/**
 * @time 2022/6/5 20:30 星期日
 * 最小优先队列：与最大优先队列相反，最小的值放在堆顶
 * 每次出队取出的是最小的值
 */
public class MinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int size;

    public MinPriorityQueue(int maxSize) {
        this.items = (T[]) new Comparable[maxSize + 1];
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
            if (less(k, k / 2)) {
                exchange(k, k / 2);
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
            int min;
            if (2 * k + 1 <= size) {
                if (less(2 * k, 2 * k + 1)) {
                    min = 2 * k;
                } else {
                    min = 2 * k + 1;
                }
            } else {
                min = 2 * k;
            }
            if (less(k, min)) {
                break;
            }
            exchange(k, min);
            k = min;
        }
    }
}
