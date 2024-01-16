package juc.partern.sequence_control;

import java.util.concurrent.locks.LockSupport;

/**
 * @author qzy
 * @time 2023/12/14 11:13 星期四
 * @title
 */
public class AlternateParkUnpark1 {
    private int loopNumber; // 循环次数
    private Thread[] threads; // 线程数组

    /**
     * 构造方法，初始化循环次数
     * @param loopNumber 循环次数
     */
    public AlternateParkUnpark1(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    /**
     * 设置线程数组
     * @param threads 线程数组
     */
    public void setThreads(Thread... threads) {
        this.threads = threads;
    }

    /**
     * 打印字符串
     * @param str 要打印的字符串
     */
    public void print(String str) {
        for (int i = 0; i < loopNumber; i++) {
            LockSupport.park(); // 阻塞当前线程直到被 unpark
            System.out.print(str); // 打印字符串
            LockSupport.unpark(nextThread()); // unpark下一个线程
        }
    }

    /**
     * 获取下一个线程
     * @return 下一个线程
     */
    private Thread nextThread() {
        Thread current = Thread.currentThread();
        int index = 0;
        for (int i = 0; i < threads.length; i++) {
            if(threads[i] == current) {
                index = i;
                break;
            }
        }
        if(index < threads.length - 1) {
            return threads[index+1];
        } else {
            return threads[0];
        }
    }

    /**
     * 开始执行所有线程
     */
    public void start() {
        for (Thread thread : threads) {
            thread.start(); // 启动线程
        }
        LockSupport.unpark(threads[0]); // unpark第一个线程
    }

    /**
     * 主方法
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        AlternateParkUnpark1 syncPark = new AlternateParkUnpark1(5);
        Thread t1 = new Thread(() -> {
            syncPark.print("a"); // 打印字符 a
        });
        Thread t2 = new Thread(() -> {
            syncPark.print("b"); // 打印字符 b
        });
        Thread t3 = new Thread(() -> {
            syncPark.print("c\n"); // 打印字符 c 和换行符
        });
        syncPark.setThreads(t1, t2, t3);
        syncPark.start(); // 开始执行所有线程
    }
}
