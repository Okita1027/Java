package datastructure.queue.blocking;

/**
 * @author qzy
 * @time 2023/10/13 9:11 星期五
 * @title
 */
public interface BlockingQueue<E> {
    void offer(E e) throws InterruptedException;

    boolean offer(E e, long timeout) throws InterruptedException;

    E poll() throws InterruptedException;

    E poll(long timeout) throws InterruptedException;

}
