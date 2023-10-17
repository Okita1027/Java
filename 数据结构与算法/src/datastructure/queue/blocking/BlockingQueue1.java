package datastructure.queue.blocking;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qzy
 * @time 2023/10/13 9:19 星期五
 * @title 阻塞队列-单锁
 */
public class BlockingQueue1<E> implements BlockingQueue<E> {
    private E[] array;
    private int head;
    private int tail;
    private int size;
    private ReentrantLock lock;
    private Condition headWaits;
    private Condition tailWaits;

    public BlockingQueue1(int capacity) {
        array = (E[]) new Object[capacity];
        lock = new ReentrantLock();
        headWaits = lock.newCondition();
        tailWaits = lock.newCondition();
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isFull()) {
                tailWaits.await();
            }
            array[tail] = e;
            tail++;
            if (tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()) {
                if (nanos <= 0) {
                    return false;
                }
                nanos = tailWaits.awaitNanos(nanos);
            }
            array[tail] = e;
            tail++;
            if (tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isEmpty()) {
                headWaits.await();
            }
            E e = array[head];
            array[head] = null;
            head++;
            if (head == array.length) {
                head = 0;
            }
            size--;
            tailWaits.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll(long timeout) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isEmpty()) {
                if (nanos <= 0) {
                    return null;
                }
                nanos = headWaits.awaitNanos(nanos);
            }
            E e = array[head];
            array[head] = null;
            head++;
            if (head == array.length) {
                head = 0;
            }
            size--;
            tailWaits.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "BlockingQueue1{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
