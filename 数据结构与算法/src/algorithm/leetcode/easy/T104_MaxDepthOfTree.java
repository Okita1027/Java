package algorithm.leetcode.easy;

import java.util.Stack;

/**
 * @author qzy
 * @time 2023/10/17 9:43 星期二
 * @title 104-树的最大深度
 */
public class T104_MaxDepthOfTree {
    public int maxDepth(TreeNode root) {
        int max = 0;
        TreeNode current = root;
        TreeNode pop = null;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (max < stack.size()) {
                    max = stack.size();
                }
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                } else {
                    current = peek.right;
                }
            }
        }
        return max;
    }


/*    // 递归
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        int left = maxDepth(root.left, max);
        int right = maxDepth(root.right, max);
        max = Math.max(left, right);
        return max;
    }

    private int maxDepth(TreeNode node, int max) {
        if (node == null) {
            return max;
        }
        return Math.max(maxDepth(node.left, max + 1), maxDepth(node.right, max + 1));
    }*/
}
