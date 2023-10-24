package algorithm.leetcode.easy;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qzy
 * @time 2023/10/22 17:26 星期日
 * @title
 */
public class T938_RangeSumBST {
    public static void main(String[] args) {
        T938_RangeSumBST fun = new T938_RangeSumBST();
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));
        int result = fun.rangeSumBST(root, 7, 15);
        System.out.println("result = " + result);

        root = new TreeNode(15, new TreeNode(9, new TreeNode(7), new TreeNode(13)), new TreeNode(21, new TreeNode(19, new TreeNode(17), null), new TreeNode(23)));
        result = fun.rangeSumBST(root, 17, 19);
        System.out.println("result = " + result);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                continue;
            }
            if (poll.val > high) {
                queue.offer(poll.left);
            } else if (poll.val < low) {
                queue.offer(poll.right);
            } else {
                sum += poll.val;
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }
        return sum;
    }

}
