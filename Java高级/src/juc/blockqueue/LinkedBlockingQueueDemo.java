package juc.blockqueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author qzy
 * @time 2023/12/1 19:22 星期五
 * @title 由链表结构组成的有界（但大小默认值Integer.MAX_VALUE）阻塞队列
 */

public class LinkedBlockingQueueDemo {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

        // 生产者线程
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Producing element: " + i);
                    queue.put(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 消费者线程
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Consuming element: " + queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

