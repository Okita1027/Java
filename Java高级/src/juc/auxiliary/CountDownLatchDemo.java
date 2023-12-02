package juc.auxiliary;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qzy
 * @time 2023/11/30 16:59 星期四
 * @title JUC 辅助类 -> 减少计数 CountDownLatch
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 3;
        CountDownLatch latch = new CountDownLatch(threadCount);

        // 创建并启动多个线程
        for (int i = 1; i <= threadCount; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("Thread running:第" + Thread.currentThread().getName() + "个同学离开了");
                latch.countDown(); // 操作完成后减少计数器的值
            }, String.valueOf(i));
            thread.start();
        }

        latch.await(); // 等待计数器变为0

        System.out.println("All threads have completed:所有同学都已离开，房间上锁！");
    }
}
