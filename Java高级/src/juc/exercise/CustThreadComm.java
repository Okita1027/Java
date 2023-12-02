package juc.exercise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qzy
 * @time 2023/11/30 14:06 星期四
 * @title 线程间的定制化通信
 * 循环N次这个过程：
 *  A打印1次->B打印2次->C打印3次
 */
public class CustThreadComm {
    public static void main(String[] args) {
        ShareResource source = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    source.print1(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    source.print2(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    source.print3(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "C").start();
    }
    static class ShareResource {
        private int flag;
        private Lock lock;
        private Condition c1;
        private Condition c2;
        private Condition c3;

        public ShareResource() {
            flag = 1;
            lock = new ReentrantLock();
            c1 = lock.newCondition();
            c2 = lock.newCondition();
            c3 = lock.newCondition();
        }

        public void print1(int loop) throws InterruptedException {
            lock.lock();
            try {
                while (flag != 1) {
                    c1.await();
                }
                for (int i = 0; i < 1; i++) {
                    System.out.println("线程" + Thread.currentThread().getName() + " -> i = " + i + "-轮数loop:" + loop);
                }
                flag = 2;
                c2.signal();
            } finally {
                lock.unlock();
            }
        }

        public void print2(int loop) throws InterruptedException {
            lock.lock();
            try {
                while (flag != 2) {
                    c2.await();
                }
                for (int i = 0; i < 2; i++) {
                    System.out.println("线程" + Thread.currentThread().getName() + " -> i = " + i + "-轮数loop:" + loop);
                }
                flag = 3;
                c3.signal();
            } finally {
                lock.unlock();
            }
        }

        public void print3(int loop) throws InterruptedException {
            lock.lock();
            try {
                while (flag != 3) {
                    c3.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("线程" + Thread.currentThread().getName() + " -> i = " + i + "-轮数loop:" + loop);
                }
                flag = 1;
                c1.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
