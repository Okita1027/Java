package juc.blockqueue;

import java.util.concurrent.SynchronousQueue;

/**
 * @author qzy
 * @time 2023/12/1 19:18 星期五
 * @title SynchronousQueue - 无缓冲的等待队列 - 不存储元素的阻塞队列，也即单个元素的队列
 */

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        // 生产者线程
        new Thread(() -> {
            try {
                System.out.println("Producing element: 1");
                queue.put(1);
                System.out.println("Producing element: 2");
                queue.put(2);
                System.out.println("Producing element: 3");
                queue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 消费者线程
        new Thread(() -> {
            try {
                Thread.sleep(1000); // 稍微延迟一下，以确保生产者线程先执行
                System.out.println("Consuming element: " + queue.take());
                System.out.println("Consuming element: " + queue.take());
                System.out.println("Consuming element: " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
