package algorithm.leetcode.easy;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/**
 * @author qzy
 * @time 2023/9/22 12:33 星期五
 */
public class T225_ImplementStackWithQueue {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        System.out.println(deque);
        for (int i = 0; i < deque.size() - 1; i++) {
            deque.add(deque.remove());
            System.out.println("deque = " + deque);
        }
        Integer removed = deque.remove();
        deque.add(removed);
        System.out.println("removed = " + removed);
        System.out.println("deque = " + deque);


        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue);
        System.out.println(queue.size());
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
            System.out.println("queue = " + queue);
        }
        System.out.println("queue = " + queue);

    }
}
