package juc.exercise;

import juc.api.GlobalLogger;

import java.util.logging.Logger;

/**
 * @Author qzy
 * @ClassName Exercise01
 * @Description 让两个线程做事儿
 * @Date 2022/10/20 8:42 星期四
 */
@SuppressWarnings("all")
public class TwoThreadExec01 {
    public static void main(String[] args) {
        Logger log = GlobalLogger.getLog("Exercise01");
        Thread t1 = new Thread(() -> {
            try {
                log.info("洗茶壶");
                Thread.sleep(1);
                log.info("烧水");
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "小明");

        Thread t2 = new Thread(() -> {
            try {
                log.info("拿茶叶");
                Thread.sleep(1);
                log.info("洗茶杯");
                Thread.sleep(2);
                //等小明那边的水烧开再泡茶
                t1.join();
                log.info("泡茶");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "大明");

        t1.start();
        t2.start();
    }
}
