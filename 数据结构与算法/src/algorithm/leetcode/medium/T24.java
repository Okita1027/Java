package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/9/17 10:08 星期日
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 */
public class T24 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode temp = sentinel;
        while (temp.next != null && temp.next.next != null) {
            ListNode leftNode = temp.next;
            ListNode rightNode = temp.next.next;
            temp.next = rightNode;
            leftNode.next = rightNode.next;
            rightNode.next = leftNode;
            temp = leftNode;
        }
        return sentinel.next;
    }
}
