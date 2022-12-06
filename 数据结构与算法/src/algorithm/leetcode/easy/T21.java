package algorithm.leetcode.easy;

/**
 * @Date 2022/6/12 17:47 星期日
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class T21 {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //构建一个新的链表
        ListNode newList = new ListNode();
        //保存头结点用于以后返回
        ListNode head = newList;
        //定义两个指针记录list1和list2
        ListNode p1 = list1;
        ListNode p2 = list2;
        //只要两个指针有任意一个达到末尾就退出循环
        while (p1 != null && p2 != null) {
            //判断两个链表的指针对应的值的大小
            //将新链表的下一个节点指向小的那一个
            //并将小的链表的指针往后移动一位
            if (p1.val <= p2.val) {
                newList.next = p1;
                p1 = p1.next;
            } else {
                newList.next = p2;
                p2 = p2.next;
            }
            //将新链表指针往后移动一位
            newList = newList.next;
        }
        //若两个链表中有任意一个达到了尽头
        //就将新链表的下一个节点指向另外一个没有达到尽头的链表
        if (p1 == null) {
            newList.next = p2;
        } else {
            newList.next = p1;
        }
        //返回新链表头结点的下一个节点
        return head.next;
    }
}
