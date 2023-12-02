package juc.blockqueue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author qzy
 * @time 2023/12/1 19:24 星期五
 * @title 由链表组成的双向阻塞队列
 */
public class LinkedBlockingDequeDemo {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<>();

        // 生产者线程
        new Thread(() -> {
            try {
                deque.putFirst("First");
                deque.putLast("Last");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 消费者线程
        new Thread(() -> {
            try {
                String first = deque.takeFirst();
                String last = deque.takeLast();
                System.out.println("First element: " + first);
                System.out.println("Last element: " + last);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
