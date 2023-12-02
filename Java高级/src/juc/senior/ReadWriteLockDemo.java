package juc.senior;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author qzy
 * @time 2023/12/1 16:41 星期五
 * @title 读写锁
 */
public class ReadWriteLockDemo {
    private static int count = 0;
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();
    public static void main(String[] args) {
        new Thread(() -> readData(), "Read").start();
        new Thread(() -> readData(), "Read").start();
        new Thread(() -> writeData(), "Write").start();
    }

    public static void readData() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "->Read Data: " + count);
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void writeData() {
        lock.writeLock().lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + "=》Write Data: " + count);
        } finally {
            lock.writeLock().unlock();
        }
    }
}