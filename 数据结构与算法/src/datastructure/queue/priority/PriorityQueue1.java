package datastructure.queue.priority;

/**
 * @author qzy
 * @time 2023/10/10 12:02 星期二
 * @title 优先队列（无序数组）
 */
public class PriorityQueue1<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public PriorityQueue1(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        array[size++] = e;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int max = getMax();
        E e = (E) array[max];
        remove(max);
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        int max = getMax();
        return (E) array[max];
    }

    private void remove(int index) {
        //当被删除元素不是最后一个元素时需要移动后续元素
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        array[--size] = null; // help GC
    }

    /**
     * 获取数组中优先级最高的元素索引
     */
    private int getMax() {
        int max = 0;
        for (int i = 1; i < size; i++) {
            if (array[max].priority() < array[i].priority()) {
                max = i;
            }
        }
        return max;
    }
}
