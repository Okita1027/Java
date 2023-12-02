package juc.blockqueue;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @author qzy
 * @time 2023/12/1 19:17 星期五
 * @title LinkedTransferQueue - 由链表组成的无界阻塞队列
 */

public class LinkedTransferQueueDemo {
    public static void main(String[] args) {
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

        // 生产者线程
        new Thread(() -> {
            try {
                String element = "Hello";
                System.out.println("Producer is waiting to transfer element: " + element);
                queue.transfer(element);
                System.out.println("Producer has transferred element: " + element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 消费者线程
        new Thread(() -> {
            try {
                Thread.sleep(2000); // 等待2秒
                String element = queue.take();
                System.out.println("Consumer has received element: " + element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
