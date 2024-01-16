package juc.basic;

import juc.api.GlobalLogger;

import java.util.logging.Logger;

/**
 * @author qzy
 * @time 2023/12/11 14:31 星期一
 * @title 活锁
 */
public class LiveLock {
    static Logger log = GlobalLogger.getLog("LiveLock");
    static volatile int count = 10;
    static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            // 期望减到 0 退出循环
            while (count > 0) {
                try {
                    Thread.sleep(2222);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count--;
                log.info("count: {" + count + "}");
            }
        }, "t1").start();
        new Thread(() -> {
            // 期望超过 20 退出循环
            while (count < 20) {
                try {
                    Thread.sleep(2222);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
                log.info("count: {" + count + "}");
            }
        }, "t2").start();
    }
}
