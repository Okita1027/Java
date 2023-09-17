package algorithm.leetcode.easy;

/**
 * @Date 2022/6/12 16:47 星期日
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class T206 {
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

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            //当前结点指向下一个结点
            current.next = previous;
            //上一个结点变为当前结点
            previous = current;
            //当前结点变为下一个结点
            current = next;
        }
        //返回反转后的链表头
        return previous;
    }
}



