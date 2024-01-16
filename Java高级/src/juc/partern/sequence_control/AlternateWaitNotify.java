package juc.partern.sequence_control;

import java.util.concurrent.locks.LockSupport;

/**
 * @author qzy
 * @time 2023/12/14 11:03 星期四
 * @title
 */
public class AlternateWaitNotify {
    private int flag;
    private int loopNumber;

    public AlternateWaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    public void print(int waitFlag, int nextFlag, String str) {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while (this.flag != waitFlag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AlternateWaitNotify syncWaitNotify = new AlternateWaitNotify(1, 5);
        new Thread(() -> {
            syncWaitNotify.print(1, 2, "a");
        }).start();
        new Thread(() -> {
            syncWaitNotify.print(2, 3, "b");
        }).start();
        new Thread(() -> {
            syncWaitNotify.print(3, 1, "c");
        }).start();


        Thread.sleep(1234);
        System.out.println("\n==============");

        Thread t1 = new Thread(() -> {
            // 当没有『许可』时，当前线程暂停运行；有『许可』时，用掉这个『许可』，当前线程恢复运行
            System.out.println("1");
            LockSupport.park();
        });
        Thread t2 = new Thread(() -> {
            System.out.println("2");
            // 给线程 t1 发放『许可』（多次连续调用 unpark 只会发放一个『许可』）
            LockSupport.unpark(t1);
        });
        t1.start();
        t2.start();
    }
}
