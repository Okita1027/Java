package datastructure.queue;

/**
 * @time 2022/6/11 19:13 星期六
 * 用数组模拟队列
 */
public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] array;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return front == -1 && rear == maxSize - 1;
    }

    //加数据（进队列）
    public boolean addElement(int element) {
        if (isFull()) {
            throw new RuntimeException("队列已满！");
        }
        rear++;
        array[rear] = element;
        return true;
    }

    //减数据（出队列）
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        front++;
        return array[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("目前队列没有任何元素！");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("\narray[%d]=%d\t", i, array[i]);
        }
    }
}

