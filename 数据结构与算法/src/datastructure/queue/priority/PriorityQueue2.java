package datastructure.queue.priority;

/**
 * @author qzy
 * @time 2023/10/10 12:52 星期二
 * @title 优先队列（有序数组）
 */
public class PriorityQueue2<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public PriorityQueue2(int capacity) {
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
        insert(e);
        size++;
        return true;
    }

    private void insert(E e) {
        int index = size - 1;
        while (index >= 0 && array[index].priority() > e.priority()) {
            array[index + 1] = array[index];
            index--;
        }
        array[index + 1] = e;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E element = (E) array[size - 1];
        array[--size] = null;
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[size - 1];
    }
}
