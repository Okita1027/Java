package juc.partern.sequence_control;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qzy
 * @time 2023/12/14 11:39 星期四
 * @title
 */
public class AlternateLock extends ReentrantLock {
        public void start(Condition first) {
        // 此方法用于开始执行交替打印
        this.lock();
        try {
            System.out.println("start!");
            first.signal();
        } finally {
            this.unlock();
        }
    }

    public void print(String str, Condition current, Condition next) {
        // 此方法用于打印内容并通知下一个线程打印
        for (int i = 0; i < loopNumber; i++) {
            this.lock();
            try {
                current.await();
                System.out.println(str);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.unlock();
            }
        }
    }

    // 循环次数
    private int loopNumber;
    public AlternateLock(int loopNumber) {
        // 构造方法，初始化循环次数
        this.loopNumber = loopNumber;
    }

    public static void main(String[] args) {
        AlternateLock as = new AlternateLock(5);
        Condition aWaitSet = as.newCondition();
        Condition bWaitSet = as.newCondition();
        Condition cWaitSet = as.newCondition();

        // 创建三个线程，分别打印a、b、c
        new Thread(() -> {
            as.print("a", aWaitSet, bWaitSet);
        }).start();
        new Thread(() -> {
            as.print("b", bWaitSet, cWaitSet);
        }).start();
        new Thread(() -> {
            as.print("c", cWaitSet, aWaitSet);
        }).start();

        // 开始执行交替打印
        as.start(aWaitSet);
    }

}