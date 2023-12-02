package juc.blockqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author qzy
 * @time 2023/12/1 19:23 星期五
 * @title 支持优先级排序的无界阻塞队列
 */
public class PriorityBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        // 生产者线程
        new Thread(() -> {
            for (int i = 5; i > 0; i--) {
                queue.put(i); // 将整数插入队列
            }
        }).start();

        // 消费者线程
        new Thread(() -> {
            try {
                while (true) {
                    Integer element = queue.take();
                    System.out.println("Consuming element: " + element);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
