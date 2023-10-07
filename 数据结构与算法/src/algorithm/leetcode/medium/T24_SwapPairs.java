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
public class T24_SwapPairs {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        //定义虚拟头结点方便后续返回链表的首个结点
        ListNode sentinel = new ListNode(-1, head);
        ListNode temp = sentinel;
        //当接下来的2个结点都存在时才继续执行
        while (temp.next != null && temp.next.next != null) {
            ListNode leftNode = temp.next;
            ListNode rightNode = temp.next.next;
            //让虚拟头结点的next域指向第一次两两交换后的左结点(新链表的首个元素)
            temp.next = rightNode;
            //交换左右结点
            leftNode.next = rightNode.next;
            rightNode.next = leftNode;
            //临时结点右移
            temp = leftNode;
        }
        return sentinel.next;
    }
}
