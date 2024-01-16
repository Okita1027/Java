package juc.partern.sequence_control;

import java.util.concurrent.locks.LockSupport;

/**
 * @author qzy
 * @time 2023/12/14 11:13 星期四
 * @title
 */
public class AlternateParkUnpark {
    static Thread t1;
    static Thread t2;
    public static void main(String[] args) {

        t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("1");
                LockSupport.unpark(t2); // 唤醒t2线程
                LockSupport.park(); // 阻塞t1线程
            }
        }, "t1");
        t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                LockSupport.park(); // 阻塞t2线程
                System.out.println("2");
                LockSupport.unpark(t1); // 唤醒t1线程
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
