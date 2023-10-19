package algorithm.leetcode.easy;

import java.util.ArrayDeque;

/**
 * @author qzy
 * @time 2023/10/17 11:07 星期二
 * @title 111-二叉树的最小深度
 */
public class T111_MinDepthOfTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }

        }

        return depth;
    }

}
