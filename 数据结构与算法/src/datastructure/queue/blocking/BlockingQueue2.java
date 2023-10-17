package datastructure.queue.blocking;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qzy
 * @time 2023/10/13 9:19 星期五
 * @title 阻塞队列-双锁
 */
public class BlockingQueue2<E> implements BlockingQueue<E> {
    private final E[] array;
    private int head;
    private int tail;
    private AtomicInteger size;
    private ReentrantLock headLock;
    private ReentrantLock tailLock;
    private Condition headWaits;
    private Condition tailWaits;

    public BlockingQueue2(int capacity) {
        array = (E[]) new Object[capacity];
        size = new AtomicInteger(0);
        headLock = new ReentrantLock();
        tailLock = new ReentrantLock();
        headWaits = headLock.newCondition();
        tailWaits = tailLock.newCondition();
    }

    private boolean isEmpty() {
        return size.get() == 0;
    }

    private boolean isFull() {
        return size.get() == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException {
        int current;    // 添加前的元素个数
        tailLock.lockInterruptibly();
        try {
            // 队列满则等待
            while (isFull()) {
                tailWaits.await();
            }
            // 队列不满则入队
            array[tail] = e;
            tail++;
            if (tail == array.length) {
                tail = 0;
            }
            // 修改size
            current = size.getAndIncrement();
            // 队列不满，但不是从满->不满，由offer线程自己唤醒其它offer线程
            if (current + 1 < array.length) {
                tailWaits.signal();
            }
        } finally {
            tailLock.unlock();
        }
        // 只有当元素个数从0变为1时，才由offer线程唤醒等待的非空线程，否则让poll线程唤醒
        if (current == 0) {
            // 通知headWaits 不为空了
            headLock.lock();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }
    }

    @Override
    public E poll() throws InterruptedException {
        E e;
        int current;    // 出队前的元素个数
        headLock.lockInterruptibly();
        try {
            // 队列空则等待
            while (isEmpty()) {
                headWaits.await();
            }
            // 队列非空则出队
            e = array[head];
            array[head] = null;
            head++;
            if (head == array.length) {
                head = 0;
            }
            //修改size
            current = size.getAndDecrement();
            // 当元素个数 > 1时，唤醒其它poll线程
            if (current > 1) {
                headWaits.signal();
            }
        } finally {
            headLock.unlock();
        }
        // 当队列由满->不满时，由poll唤醒offer线程
        if (current == array.length) {
            // 通知tailWaits 队列不满
            tailLock.lock();
            try {
                tailWaits.signal();
            } finally {
                tailLock.unlock();
            }
        }
        return e;
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        tailLock.lockInterruptibly();
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
            size.getAndIncrement();

        } finally {
            tailLock.unlock();
        }

        headLock.lock();
        try {
            headWaits.signal();
        } finally {
            headLock.unlock();
        }


        return true;
    }

    @Override
    public E poll(long timeout) throws InterruptedException {
        E e;
        headLock.lockInterruptibly();
        try {
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isEmpty()) {
                if (nanos <= 0) {
                    return null;
                }
                nanos = headWaits.awaitNanos(nanos);
            }
            e = array[head];
            array[head] = null;
            head++;
            if (head == array.length) {
                head = 0;
            }
            size.getAndDecrement();

        } finally {
            headLock.unlock();
        }

        tailLock.lock();
        try {
            tailWaits.signal();
        } finally {
            tailLock.unlock();
        }

        return e;
    }

    @Override
    public String toString() {
        return "BlockingQueue2{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
