package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/10/17 9:41 星期二
 * @title 公用的链表节点
 */
public class ListNode {
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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
