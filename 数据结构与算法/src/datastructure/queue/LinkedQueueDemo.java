package datastructure.queue;

/**
 * @time 2022/6/11 22:10 星期六
 * 链队列测试
 */
public class LinkedQueueDemo {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
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
}
