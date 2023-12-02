package juc.auxiliary;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author qzy
 * @time 2023/12/1 11:16 星期五
 * @title JUC辅助类——>Semaphore（信号灯）
 */
public class SemaphoreDemo {
    // 6辆汽车要轮流停到3个停车位
    public static void main(String[] args) {
        int parking = 3;
        int car = 6;
        // 参数是最大信号量（可以看成最大线程池），每个信号量初始化为一个最多只能分发一个许可证。使用 acquire 方法获得许可证，release 方法释放许可
        Semaphore semaphore = new Semaphore(parking);
        for (int i = 1; i <= car; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "号车抢到了车位……");
                    int parkingTime = new Random().nextInt(3) + 1;
                    TimeUnit.SECONDS.sleep(parkingTime);    // i 号车停了 1 - 3秒后离开了
                    System.out.println(Thread.currentThread().getName() + "号车停了" + parkingTime + "秒后离开了停车场！");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
