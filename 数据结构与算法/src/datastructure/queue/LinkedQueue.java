package datastructure.queue;

import java.util.Iterator;

/**
 * @time 2022/6/11 21:37 星期六
 * 链队列
 */
public class LinkedQueue<T> implements Iterable {
    private int length;
    private Node<T> front;
    private Node<T> rear;

    public LinkedQueue() {
        length = 0;
        front = rear = new Node<>(null);
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    public void enQueue(T value) {
        if (isEmpty()) {
            front = rear = new Node<>(value);
        } else {
            Node<T> newNode = new Node<>(value);
            front.next = newNode;
            front = newNode;
        }
        length++;
    }

    public T deQueue() {
        if (isEmpty())
            return null;
        T value = rear.data;
        rear = rear.next;
        length--;
        return value;
    }

    public void show() {
        Node<T> temp = rear;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator<T> {
        Node<T> temp = rear;
        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public T next() {
            T data = temp.data;
            temp = temp.next;
            return data;
        }
    }
}
