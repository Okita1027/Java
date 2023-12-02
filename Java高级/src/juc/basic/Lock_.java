package juc.basic;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qzy
 * @time 2023/11/28 15:49 星期二
 * @title 售票案例，使用Lock而不是synchronized完成
 * Lock和synchronized有以下几点不同∶
 * 1. Lock是一个接口，而synchronized 是Java 中的关键字，synchronized是内置的语言实现;
 * 2. synchronized在发生异常时，会自动释放线程占有的锁，因此不会导致死锁现象发生;
 * 而Lock在发生异常时，如果没有主动通过unLock()去释放锁,则很可能造成死锁现象，因此使用Lock 时需要在finally块中释放锁;
 * 3. Lock 可以让等待锁的线程响应中断，而synchronized 却不行，使用synchronized 时，等待的线程会一直等待下去，不能够响应中断;
 * 4．通过Lock 可以知道有没有成功获取锁，而synchronized 却无法办到。
 * 5. Lock 可以提高多个线程进行读操作的效率。
 * 在性能上来说，如果竞争资源不激烈，两者的性能是差不多的，而当竞争资源非常激烈时（即有大量线程同时竞争），此时Lock 的性能要远远优于synchronized
 */
public class Lock_ {
    public static void main(String[] args) {
        Ticket sell = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                sell.sell();
                System.out.println("A窗口售票，剩余票数:" + sell.count);
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                sell.sell();
                System.out.println("B窗口售票，剩余票数:" + sell.count);
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                sell.sell();
                System.out.println("C窗口售票，剩余票数:" + sell.count);
            }
        }, "C").start();

    }
    
    static class Ticket {
        int count;
        ReentrantLock lock;
        public Ticket() {
            count = 50;
            lock = new ReentrantLock();
        }

        private void sell() {
            lock.lock();
            try {
                if (count > 0) {
                    count--;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
