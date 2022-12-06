package datastructure.stack;

/**
 * @time 2022/5/28 20:02 星期六
 * 链栈
 */
public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack integerLinkedStack = new LinkedStack();
        System.out.println(integerLinkedStack.isEmpty());
        integerLinkedStack.push(new Node<>(1));
        integerLinkedStack.push(new Node<>(3));
        integerLinkedStack.push(new Node<>(2));
        integerLinkedStack.push(new Node<>(9));
        integerLinkedStack.push(new Node<>(8));
        System.out.println(integerLinkedStack.size());
        System.out.println("\n======================");
        integerLinkedStack.print();
        System.out.println("\n======================");
        System.out.println(integerLinkedStack.pop());
        System.out.println("\n======================");
        System.out.println(integerLinkedStack.pop());
        System.out.println("\n======================");
        System.out.println(integerLinkedStack.size());
        System.out.println("\n======================");
        integerLinkedStack.print();
    }
}

class LinkedStack {
    private final Node<Integer> head = new Node<>(0);

    public Node<Integer> getHead() {
        return head;
    }

    public LinkedStack() {
        head.next = null;
        head.prior = null;
    }

    protected boolean isEmpty() {
        return head.next == null;
    }

    protected void push(Node node) {
        if (isEmpty()) {
            head.next = node;
            node.prior = head;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prior = temp;
    }

    protected Object pop() {
        Object value;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        value = temp.data;
        temp.prior.next = null;
        return value;
    }

    protected int size() {
        int count = 0;
        Node temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    protected void print() {
        if (isEmpty()) {
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        do {
            System.out.print(temp.data + "\t");
            temp = temp.prior;
        }while (temp != null && temp != head);
    }
}

class Node<T> {
    protected T data;
    protected Node next;
    protected Node prior;

    public Node(T data) {
        this.data = data;
    }
}