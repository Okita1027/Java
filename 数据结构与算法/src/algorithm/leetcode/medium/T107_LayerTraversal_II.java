package algorithm.leetcode.medium;

import java.util.*;

/**
 * @author qzy
 * @time 2023/11/10 10:12 星期五
 * @title 107-二叉树的层序遍历II
 */
public class T107_LayerTraversal_II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<List<Integer>> result = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            // 当前层的结点个数
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            /* 把这一层的结点值加入list,并把下一层的结点加入队列 */
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }
}
