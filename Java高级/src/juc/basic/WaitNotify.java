package juc.basic;

import juc.api.GlobalLogger;

import java.util.logging.Logger;

/**
 * @author qzy
 * @time 2023/12/11 10:50 星期一
 * @title
 */
public class WaitNotify {
    static Logger log = GlobalLogger.getLog("wait_notify");
    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (room) {
                log.info("有烟没？[{ " + hasCigarette + " }]");
                while (!hasCigarette) {
                    log.info("没烟，先歇会！");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("有烟没？[{" + hasCigarette + "}]");
                if (hasCigarette) {
                    log.info("可以开始干活了");
                } else {
                    log.info("没干成活...");
                }
            }
        }, "小南").start();

        new Thread(() -> {
            synchronized (room) {
                log.info("外卖送到没？[{" + hasTakeout + "}]");
                while (!hasTakeout) {
                    log.info("没外卖，先歇会！");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("外卖送到没？[{" + hasTakeout + "}]");
                if (hasTakeout) {
                    log.info("可以开始干活了");
                } else {
                    log.info("没干成活...");
                }
            }
        }, "小女").start();

        // 过了1s香烟和外卖送到了
        Thread.sleep(1000);
        new Thread(() -> {
            synchronized (room) {
                hasTakeout = true;
                log.info("外卖到了噢！");
                room.notifyAll();
            }
        }, "送外卖的").start();

        new Thread(() -> {
            synchronized (room) {
                hasCigarette = true;
                log.info("香烟到了噢！");
                room.notifyAll();
            }
        }, "送香烟的").start();
    }
}
