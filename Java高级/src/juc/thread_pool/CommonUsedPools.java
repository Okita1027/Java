package juc.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author qzy
 * @time 2023/12/2 16:59 星期六
 * @title 常用的三个线程池
 */
public class CommonUsedPools {
    public static void main(String[] args) {
        ExecutorService singlePool = Executors.newSingleThreadExecutor();   // 单线程的池子
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);    // 固定线程的池子
        ExecutorService cachedPool = Executors.newCachedThreadPool();   // 可按需自动扩容的池子

        try {
            for (int i = 0; i < 10; i++) {
                singlePool.execute(() -> {
                    System.out.println("SSS=SinglePool->" + Thread.currentThread().getName());
                });
                fixedPool.execute(() -> {
                    System.out.println("FFF=FixedPool->" + Thread.currentThread().getName());
                });
                cachedPool.execute(() -> {
                    System.out.println("CCC=CachedPool->" + Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            singlePool.shutdown();
            fixedPool.shutdown();
            cachedPool.shutdown();
        }

    }
}
