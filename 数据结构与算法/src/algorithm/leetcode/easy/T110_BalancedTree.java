package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/10/26 10:38 星期四
 * @title 110-平衡二叉树
 */
public class T110_BalancedTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左子树的高度
        int left = depth(root.left);
        if (left == -1) {
            return -1;
        }
        // 计算右子树的高度
        int right = depth(root.right);
        if (right == -1) {
            return -1;
        }
        // 若2边的差值大于1了，则认为不平衡
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        // 返回当前这一颗小子树中更高的值
        return Math.max(left, right) + 1;
    }
}
