package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/10/9 23:38 星期一
 * @title 设计循环双端队列
 */
public class T641_DesignCircleDeque {
    /*
    设计实现双端队列。

    实现 MyCircularDeque 类:

    MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
    boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
    boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
    boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
    boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
    int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
    int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
    boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
    boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
     */
/*    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));                    // 返回 true
        System.out.println(circularDeque.insertLast(2));                    // 返回 true
        System.out.println(circularDeque.insertFront(3));                // 返回 true
        System.out.println(circularDeque.insertFront(4));                // 已经满了，返回 false
        System.out.println(circularDeque.getRear());                // 返回 2
        System.out.println(circularDeque.isFull());                    // 返回 true
        System.out.println(circularDeque.deleteLast());                // 返回 true
        System.out.println(circularDeque.insertFront(4));                // 返回 true
        System.out.println(circularDeque.getFront());            // 返回 4
    }*/

}


/*
class MyCircularDeque {
    int[] data;
    int head;
    int tail;
    public MyCircularDeque(int k) {
        // 预留一个位置判断队列满
        data = new int[k + 1];
    }
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = decrement(head);
        data[head] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        data[tail] = value;
        tail = increment(tail);
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = increment(head);
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = decrement(tail);
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return data[decrement(tail)];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        if (tail > head) {
            return tail - head == data.length - 1;
        } else if (tail < head) {
            return head - tail == 1;
        } else {
            return false;
        }
    }

    */
/**
     * 复用解决循环队列中下标的越界问题
     * @param index 当前下标
     * @return 移动后的下标
     *//*

    private int increment(int index) {
        if (index + 1 >= data.length) {
            return 0;
        }
        return (index + 1);
    }
    private int decrement(int index) {
        if (index - 1 < 0) {
            return data.length - 1;
        }
        return (index - 1);
    }
}
*/
