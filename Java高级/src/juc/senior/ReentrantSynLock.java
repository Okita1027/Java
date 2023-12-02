package juc.senior;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qzy
 * @time 2023/11/30 14:40 星期四
 * @title 可重入锁
 */
public class ReentrantSynLock {
    public static void main(String[] args) {
        ReentrantSynLock thread = new ReentrantSynLock();
        new Thread(() -> {
            thread.funSyn();
        }, "funSyn").start();

        new Thread(() -> {
            thread.funLock();
        }, "funLock1").start();
        new Thread(() -> {
            thread.funLock();
        }, "funLock2").start();
    }

    /*
        Synchronized是可重入锁
     */
    public synchronized void funSyn() {
        System.out.println("外层");
        synchronized (this) {
            System.out.println("中层");
            synchronized (this) {
                System.out.println("内层");
            }
        }
    }

    /*
        lock演示可重入锁
     */
    Lock lock = new ReentrantLock();
    public void funLock() {
        lock.lock();
        try {
            System.out.println("1外层");
            lock.lock();
            try {
                System.out.println("2中层");
                lock.lock();
                try {
                    System.out.println("3内层");
                } finally {
                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }
        } finally {
            lock.unlock();
        }
    }
}
