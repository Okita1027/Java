package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/9/21 11:01 星期四
 *
 */
public class T160 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA;
        ListNode pointB = headB;
        int lengthA, lengthB;
        lengthA = lengthB = 0;
        while (pointA != null) {
            pointA = pointA.next;
            lengthA++;
        }
        while (pointB != null) {
            pointB = pointB.next;
            lengthB++;
        }

        pointA = headA;
        pointB = headB;
        int gap = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            while (gap-- > 0) {
                pointA = pointA.next;
            }
        } else {
            while (gap-- > 0) {
                pointB = pointB.next;
            }
        }
        while (pointA != pointB) {
            pointA = pointA.next;
            pointB = pointB.next;
        }
        return pointA;
    }

}
