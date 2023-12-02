package juc.exercise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qzy
 * @time 2023/11/29 17:48 星期三
 * @title Lock实现->线程间的通信，多个线程的 +1 -1 案例
 */
public class ThreadCommunicationLock {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    count.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                System.out.println("INCREMENT-> count : " + count.count);
            }
        }, "AAA->INCREMENT").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    count.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                System.out.println("DECREMENT -> count : " + count.count);
            }
        }, "BBB->DECREMENT").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    count.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                System.out.println("INCREMENT-> count : " + count.count);
            }
        }, "CCC->INCREMENT").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    count.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                System.out.println("DECREMENT -> count : " + count.count);
            }
        }, "DDD->DECREMENT").start();

    }

    static class Count {
        int count = 0;
        Lock lock;
        Condition condition;

        public Count() {
            lock = new ReentrantLock();
            condition = lock.newCondition();
        }

        public void increment() throws InterruptedException {
            lock.lock();
            try {
                // 不能写if,否则>2个线程时可能会出现虚假唤醒的情况
                while (count != 0) {
                    condition.await();  // 进入阻塞状态
                }
                count++;
                System.out.println(Thread.currentThread().getName() + "::" + count);
                condition.signalAll();  // 唤醒其它线程
            } finally {
                lock.unlock();
            }

        }

        public void decrement() throws InterruptedException {
            lock.lock();
            try {
                // 不能写if,否则>2个线程时可能会出现虚假唤醒的情况
                while (count != 1) {
                    condition.await();  // 进入阻塞状态
                }
                count--;
                System.out.println(Thread.currentThread().getName() + "--" + count);
                condition.signalAll();  // 唤醒其它线程
            } finally {
                lock.unlock();
            }

        }
    }
}
