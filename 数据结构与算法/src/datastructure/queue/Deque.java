package datastructure.queue;

/**
 * @author qzy
 * @time 2023/10/9 18:36 星期一
 * @title 双端队列接口
 */
public interface Deque<E> {

    boolean offerFirst(E e);

    boolean offerLast(E e);

    E pollFirst();

    E pollLast();

    E peekFirst();

    E peekLast();

    boolean isEmpty();

    boolean isFull();
}
