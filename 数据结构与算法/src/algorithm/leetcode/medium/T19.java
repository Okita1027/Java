package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/9/18 8:25 星期一
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class T19 {

    private static class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 获得链表总结点的个数
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        //倒数第n个结点 -> 正数第count - n + 1个结点
        int targetIndex = count - n + 1;
        ListNode sentinel = new ListNode(-1, head);
        ListNode current = sentinel;
        for (int i = 1; i < targetIndex; i++) {
            current = current.next;
        }
        current.next = current.next.next;

        return sentinel.next;
    }
}
