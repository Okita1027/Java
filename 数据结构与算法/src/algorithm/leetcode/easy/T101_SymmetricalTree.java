package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/10/17 9:36 星期二
 * @title 101-对称二叉树
 */
public class T101_SymmetricalTree {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        // 左右都为空：对称
        if (left == null && right == null) {
            return true;
        }
        // 有一个不为空：不对称
        if (left == null || right == null) {
            return false;
        }
        // 左右不相等：不对称
        if (left.val != right.val) {
            return false;
        }
        // 继续比较他们的子树节点
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
