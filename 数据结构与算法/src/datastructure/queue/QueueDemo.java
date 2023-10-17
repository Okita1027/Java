package datastructure.queue;

import datastructure.queue.blocking.BlockingQueue1;
import datastructure.queue.blocking.BlockingQueue2;
import datastructure.queue.priority.Entry;
import datastructure.queue.priority.PriorityQueue1;
import datastructure.queue.priority.PriorityQueue2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author qzy
 * @time 2023/10/9 19:23 星期一
 * @title 测试类
 */
public class QueueDemo {
    @Test
    void CircleArrayQueueDemo() {
        //循环队列约定空出一个空间作为判断队列满的标识,传进去4，实际只能存储3个元素
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        System.out.println(circleArrayQueue.isEmpty());
        System.out.println(circleArrayQueue.isFull());
        circleArrayQueue.addElement(1);
        circleArrayQueue.addElement(2);
        circleArrayQueue.addElement(3);
        System.out.println(circleArrayQueue.isFull());
        circleArrayQueue.showQueue();

        System.out.println(circleArrayQueue.getElement());
        circleArrayQueue.addElement(0);
        circleArrayQueue.showQueue();
    }

    @Test
    void LinkedListQueueDemo() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.enQueue(4);
        queue.enQueue(2);
        queue.enQueue(1);
//        queue.show();
//        System.out.println("queue.deQueue() = " + queue.deQueue());
//        System.out.println("queue.deQueue() = " + queue.deQueue());

        for (Object next : queue) {
            System.out.println("next = " + next);
        }
    }

    @Test
    void LinkedListDequeDemo() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<Integer>(5);
        deque.offerFirst(3);
        deque.offerFirst(2);
        deque.offerFirst(1);
        deque.offerLast(4);
        deque.offerLast(5);
        for (Integer element : deque) {
            System.out.println(element);
        }
        Assertions.assertEquals(5, deque.pollLast());
        Assertions.assertEquals(1, deque.pollFirst());
    }

    @Test
    void PriorityQueue1() {
        PriorityQueue1<Entry> queue = new PriorityQueue1<>(5);
        queue.offer(new Entry("task1", 1));
        queue.offer(new Entry("task2", 3));
        queue.offer(new Entry("task3", 2));
        queue.offer(new Entry("task4", 5));
        queue.offer(new Entry("task5", 4));
        System.out.println("queue.poll() = " + queue.poll());
//        System.out.println("queue.poll() = " + queue.peek().getValue());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
    }

    @Test
    void PriorityQueue2() {
        PriorityQueue2<Entry> queue = new PriorityQueue2<>(5);
        queue.offer(new Entry("task1", 1));
        queue.offer(new Entry("task2", 3));
        queue.offer(new Entry("task3", 2));
        queue.offer(new Entry("task4", 5));
        queue.offer(new Entry("task5", 4));
        System.out.println("queue.poll() = " + queue.poll());
//        System.out.println("queue.poll() = " + queue.peek().getValue());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
    }


    @Test
    void BlockingQueue1() throws InterruptedException {
        BlockingQueue1<Integer> queue = new BlockingQueue1<>(5);
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("queue.poll(3000) = " + queue.poll(3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        t1.setName("线程1");

        Thread t2 = new Thread(() -> {
            try {
                queue.offer(1);
                queue.offer(2);
                queue.offer(3);
                queue.offer(4);
                System.out.println(queue);
                queue.offer(5, 1000);
                System.out.println(queue);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t2.setName("线程2");

        t1.start();
        t2.start();
    }

    @Test
    void BlockingQueue2() throws InterruptedException{
        BlockingQueue2<Integer> queue = new BlockingQueue2<>(5);
        new Thread(() -> {
            try {
                queue.offer(1);
                queue.offer(2);
                queue.offer(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "offer").start();
        new Thread(() -> {
            try {
                System.out.println("queue.poll() = " + queue.poll());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "poll").start();
    }
}
