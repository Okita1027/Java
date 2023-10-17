package algorithm.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author qzy
 * @time 2023/10/12 17:08 星期四
 * @title 合并k个升序链表
 */
public class T23_MergeKAscendingLinkedList {
/*    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue queue = new PriorityQueue(lists.length);
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        ListNode sentinel = new ListNode(-1, null);
        ListNode temp = sentinel;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            sentinel.next = poll;
            sentinel = poll;
            if (poll.next != null) {
                queue.offer(poll.next);
            }
        }
        return sentinel.next;
    }

    private class PriorityQueue {
        ListNode[] array;
        int size;

        public PriorityQueue(int capacity) {
            array = new ListNode[capacity];
        }

        public boolean offer(ListNode e) {
            if (isFull()) {
                return false;
            }
            int child = size++; // 下一个元素的位置
            int parent = (child - 1) / 2;   // 父节点计算公式
            // 比较要加入的(子）结点与父节点的优先级
            while (child != 0 && e.val < array[parent].val) {
                // 若子节点优先级比父节点高，则将父节点变成子节点
                array[child] = array[parent];
                child = parent;
                parent = (child - 1) / 2;
            }
            // 子节点不比父节点优先级高了，将要加入的元素赋值给此结点
            array[child] = e;
            return true;
        }

        public ListNode poll() {
            if (isEmpty()) {
                return null;
            }
            // 交换堆顶与堆底元素
            swap(0, size--);
            // 记录最大值
            ListNode e = array[size];
            // 帮助垃圾回收
            array[size] = null;
            // 下潜
            down(0);
            return e;
        }


        private void down(int parent) {
            int leftChild = 2 * parent + 1;
            int rightChild = leftChild + 1;
            // 假设父节点的优先级最高
            int max = parent;
            // 记录左孩子和右孩子和父节点中优先级最高的元素
            if (leftChild < size && array[leftChild].val < array[max].val) {
                max = leftChild;
            }
            if (rightChild < size && array[rightChild].val < array[max].val) {
                max = rightChild;
            }
            // 父节点的优先级不是最高的
            if (max != parent) {
                //交换孩子与父亲
                swap(max, parent);
                //递归判断下一个父子结点
                down(max);
            }
        }

        private void swap(int i, int j) {
            ListNode temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == array.length;
        }
    }*/
    private class ListNode {
        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(3, Comparator.comparingInt(o -> o.val));
        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }
        ListNode sentinel = new ListNode(-1, null);
        ListNode temp = sentinel;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            temp.next = node;
            temp = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return sentinel.next;
    }
}