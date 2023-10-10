package datastructure.queue;

import java.util.Iterator;

/**
 * @author qzy
 * @time 2023/10/9 18:33 星期一
 * @title 数组实现双端队列
 */
public class ArrayDeque<E> implements Deque<E>, Iterable<E> {
    /*
                    h
            t
        0   1   2   3
        b           a
     */
    @Override
    public boolean offerFirst(E e) {
        if (isFull()) {
            return false;
        }
        head = decrement(head, array.length);
        array[head] = e;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) {
            return false;
        }
        array[tail] = e;
        tail = increment(tail, array.length);
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        E e = array[head];
        array[head] = null;
        head = increment(head, array.length);
        return e;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        tail = decrement(tail, array.length);
        E e = array[tail];
        array[tail] = null;
        return e;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return array[decrement(tail, array.length)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        if (tail > head) {
            return tail - head == array.length - 1;
        } else if (tail < head) {
            return head - tail == 1;
        } else {
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E e = array[p];
                p = increment(p, array.length);
                return e;
            }
        };
    }

    E[] array;
    int head;
    int tail;

    @SuppressWarnings("unchecked")
    public ArrayDeque(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    /**
     * 数组实现过程中入队、出队涉及到的索引问题
     * @param i 当前索引
     * @param length 队列容量
     * @return 增长后的索引
     */
    private static int increment(int i, int length) {
        if (i + 1 >= length) {
            return 0;
        }
        return i + 1;
    }

    /**
     * 数组实现过程中入入队、出队涉及到的索引问题
     * @param i 当前索引
     * @param length 队列容量
     * @return 减少后的索引
     */
    private static int decrement(int i, int length) {
        if (i - 1 < 0) {
            return length - 1;
        }
        return i - 1;
    }
}
