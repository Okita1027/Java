package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/12/7 10:27 星期四
 * @title 对链表进行插入排序
 */
public class T147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head); // 哑节点
        ListNode current = head.next; // 当前需要插入的节点
        ListNode prev = head; // 插入节点的前一个节点

        while (current != null) {
            if (prev.val <= current.val) {
                prev = current;
                current = current.next;
            } else {
                ListNode insertPos = dummy; // 插入位置从哑节点开始
                while (insertPos.next.val <= current.val) {
                    insertPos = insertPos.next;
                }
                prev.next = current.next; // 断开当前节点
                current.next = insertPos.next; // 插入节点至正确位置
                insertPos.next = current;
                current = prev.next; // 更新当前节点
            }
        }

        return dummy.next;
    }
}
