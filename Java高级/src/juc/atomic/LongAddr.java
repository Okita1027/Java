package juc.atomic;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author qzy
 * @time 2023/12/17 9:20 星期日
 * @title 原子累加器
 */
public class LongAddr {
    public static void main(String[] args) {
        LongAdder adder = new LongAdder();

        // 多个线程同时对add方法进行累加操作
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                adder.add(1);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                adder.add(1);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出累加器的最终值
        System.out.println("Final value: " + adder.sum());
    }
}
