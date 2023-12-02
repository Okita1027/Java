package juc.blockqueue;

/**
 * @author qzy
 * @time 2023/12/1 19:21 星期五
 * @title 由数组结构组成的有界阻塞队列
 */
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        // 创建一个长度为10的阻塞队列
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        // 生产者线程
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    queue.put(i);
                    System.out.println("Put element: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 消费者线程
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    int element = queue.take();
                    System.out.println("Take element: " + element);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

