package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/9/17 9:55 星期日
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
public class T203_RemoveLinkedListElements {

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

    public ListNode removeElements(ListNode head, int val) {
        //哨兵结点
        ListNode sentinel = new ListNode(-1, head);
        //遍历链表，删除值为val的元素
        ListNode temp = sentinel;
        while (temp.next != null) {
            if (temp.next.val == val) {
                //符合要求，删除结点
                temp.next = temp.next.next;
            } else {
                //不符合，继续后移
                temp = temp.next;
            }
        }
        //返回新的头结点
        return sentinel.next;
    }
}
