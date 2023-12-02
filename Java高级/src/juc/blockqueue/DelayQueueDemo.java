package juc.blockqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author qzy
 * @time 2023/12/1 19:16 星期五
 * @title 延迟队列
 */

public class DelayQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedElement> queue = new DelayQueue<>();

        // 生产者线程
        new Thread(() -> {
            try {
                queue.put(new DelayedElement("Element 1", 3000));
                queue.put(new DelayedElement("Element 2", 2000));
                queue.put(new DelayedElement("Element 3", 4000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        // 消费者线程
        new Thread(() -> {
            try {
                while (true) {
                    DelayedElement element = queue.take();
                    System.out.println("Consuming element: " + element);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    static class DelayedElement implements Delayed {
        private String name;
        private long delayTime;

        public DelayedElement(String name, long delayTime) {
            this.name = name;
            this.delayTime = System.currentTimeMillis() + delayTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long remainingTime = delayTime - System.currentTimeMillis();
            return unit.convert(remainingTime, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            long diff = this.delayTime - ((DelayedElement) other).delayTime;
            return Long.compare(diff, 0);
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
