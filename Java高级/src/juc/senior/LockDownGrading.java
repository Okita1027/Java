package juc.senior;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author qzy
 * @time 2023/12/1 17:50 星期五
 * @title 锁降级
 * 锁降级（Lock Downgrading）是指在持有一个较高级别的锁时，先获取一个更低级别的锁，然后释放较高级别的锁的过程。
 * 这个过程可以保证线程在数据访问期间的安全性，并且可以提高并发性能。
 * <p>
 * 典型的锁降级场景如下：
 *  获取写锁：首先获取写锁，即排他锁，确保数据的一致性和安全性。
 *  获取读锁：在持有写锁的情况下，再获取读锁，即共享锁。这样可以允许其他线程同时读取数据，提高并发性能。
 *  释放写锁：在完成读操作后，释放写锁，保留读锁的持有状态。
 *  <p>
 * 锁降级的优点是允许多个线程并发地读取数据，提高了程序的性能。同时，由于降级操作是自上而下的，不会出现死锁情况。
 */
public class LockDownGrading {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static String data;

    public static void main(String[] args) {
        writeData();
        readData();
    }

    public static void writeData() {
        // 获取写锁，执行写操作
        lock.writeLock().lock();
        try {
            data = "Some data";
            System.out.println("Write Data: " + data);

            // 获取读锁，实现锁降级
            lock.readLock().lock();
        } finally {
            // 释放写锁，实现锁降级
            lock.writeLock().unlock();
        }
    }

    public static void readData() {
        try {
            // 使用读锁读取数据
            lock.readLock().lock();
            System.out.println("Read Data: " + data);
        } finally {
            lock.readLock().unlock();
        }
    }
}
