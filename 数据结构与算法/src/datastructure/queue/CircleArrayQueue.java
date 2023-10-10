package datastructure.queue;

/**
 * @time 2022/6/4 16:09 星期六
 * 数组模拟环形队列
 */
public class CircleArrayQueue {
    private int front;
    private int rear;
    private final int maxSize;
    private final int[] array;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
        array = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void addElement(int element) {
        if (isFull()) {
            throw new RuntimeException("队列已满！");
        }
        array[rear] = element;
        // 防止假溢出
        rear = (rear + 1) % maxSize;
    }

    public int getElement() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        int value = array[front];
        // 防止假溢出
        front = (front + 1) % maxSize;
        return value;
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("目前队列没有任何元素！");
            return;
        }
        // 从front开始遍历N个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("\narray[%d]=%d\t", i % maxSize, array[i%maxSize]);
        }
        System.out.println();
    }
}