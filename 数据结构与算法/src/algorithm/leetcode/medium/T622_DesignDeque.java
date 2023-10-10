package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/10/10 18:37 星期二
 * @title 设计双端队列
 */
public class T622_DesignDeque {
/*    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1);  // 返回 true
        circularQueue.enQueue(2);  // 返回 true
        circularQueue.enQueue(3);  // 返回 true
        circularQueue.enQueue(4);  // 返回 false，队列已满
        circularQueue.Rear();  // 返回 3
        circularQueue.isFull();  // 返回 true
        circularQueue.deQueue();  // 返回 true
        circularQueue.enQueue(4);  // 返回 true
        circularQueue.Rear();  // 返回 4
    }*/
}
/*
class MyCircularQueue {

    int[] array;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        //留一个位置用于判断元素已满
        array = new int[k + 1];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        array[front++] = value;
        // 元素到达数组末尾，重置为0循环队列
        if (front == array.length) {
            front = 0;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        rear++;
        // 元素到达数组末尾，重置为0循环队列
        if (rear == array.length) {
            rear = 0;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return array[rear];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        if (front == 0) {
            return array[array.length - 1];
        }
        return array[front - 1];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        // front指针可能在数组末尾，而rear在0索引处
        return (front + 1) % array.length == rear;
    }
}*/
