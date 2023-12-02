package juc.auxiliary;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author qzy
 * @time 2023/11/30 17:06 星期四
 * @title JUC辅助类——> CyclicBarrier 循环栅栏
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        final int DragonBallNumber = 7;    // 收集7龙珠召唤神龙
        // 第一个参数是屏障数，每执行一次await会+1，直到7再执行下面的代码
        CyclicBarrier barrier = new CyclicBarrier(DragonBallNumber, () -> {
            System.out.println("Barrier action is triggered->7龙珠收集完毕，召唤神龙！");
        });

        // 创建并启动多个线程
        for (int i = 1; i <= DragonBallNumber; i++) {
            new Thread(() -> {
                System.out.println("Thread is waiting at the barrier -> 已收集" + Thread.currentThread().getName() + "星龙珠……");
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread continues to run after the barrier - 这条语句在await后面 -> （线程仍在执行）");
            }, String.valueOf(i)).start();
        }
    }
}
