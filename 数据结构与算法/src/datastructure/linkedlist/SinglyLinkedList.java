package datastructure.linkedlist;

import java.util.function.Consumer;

/**
 * @author qzy
 * @time 2023/9/12 17:22 星期二
 * 单向链表(不循环)
 */
public class SinglyLinkedList {
    /**
     * 头结点
     */
    private final Node head;

    /**
     * 节点类
     */
    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public SinglyLinkedList() {
        //初始化头结点，value->链表元素的个数
        head = new Node(0, null);
    }

    /**
     * 添加元素（头插法）
     * @param value 元素值
     */
    public void addHead(int value) {
        head.next = new Node(value, head.next);
        head.value++;
    }

    /**
     * 尾插法
     * @param value 元素值
     */
    public void addTrail(int value) {
        findLastNode().next = new Node(value, null);
        head.value++;
    }

    /**
     * 在指定位置后插入元素
     * @param index 索引位置
     * @param value 元素值
     */
    public void add(int index, int value) {
        Node temp = head.next;
        while (--index > 0) {
            temp = temp.next;
        }
        temp.next = new Node(value, temp.next);
        head.value++;
    }

    /**
     * 查找最后一个结点的位置
     * @return  最后一个结点
     */
    private Node findLastNode() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 查找指定索引处的结点
     * @param index 索引
     * @return 指定索引处的结点
     */
    private Node findNode(int index) {
        Node temp = head.next;
        while (--index >= 0) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 获取指定索引的元素值
     * @param index 索引
     * @return 元素值
     */
    public int get(int index) {
        Node node = findNode(index);
        return node.value;
    }

    /**
     * 获取链表总元素个数
     * @return 链表总元素个数
     */
    public int getLength() {
        return head.value;
    }

    /**
     * 删除第index个元素并返回
     * @param index 元素位置
     * @return 被删除的元素
     */
    public int remove(int index) {
        if (index > head.value) {
            throw new RuntimeException("index不合法！");
        }
        Node temp = head.next;
        while (--index > 1) {
            temp = temp.next;
        }
        Node removed = temp.next;
        temp.next = temp.next.next;
        head.value--;
        return removed.value;
    }

    /**
     * 遍历
     * @param consumer 消费者接口
     */
    public void loop(Consumer<Integer> consumer) {
        Node temp = head.next;
        while (temp != null) {
            consumer.accept(temp.value);
            temp = temp.next;
        }
    }

    public void loopRecursion() {
        recursion(head.next);
    }
    private void recursion(Node node) {
        if (node == null) {
            return;
        }
        System.out.print("before" + node.value);
        recursion(node.next);
        System.out.print("after" + node.value);
    }

}
