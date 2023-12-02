package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/11/23 14:44 星期四
 * @title 112-路径总和
 */
public class T112_HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null || targetSum < root.val) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
