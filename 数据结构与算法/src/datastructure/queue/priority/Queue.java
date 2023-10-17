package datastructure.queue.priority;

/**
 * @author qzy
 * @time 2023/10/10 12:03 星期二
 * @title 队列通用方法
 */
public interface Queue<E> {
    boolean isEmpty();
    boolean isFull();

    boolean offer(E e);

    E poll();

    E peek();
}
