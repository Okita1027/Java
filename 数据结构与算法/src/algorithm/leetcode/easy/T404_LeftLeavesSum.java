package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/11/23 13:50 星期四
 * @title 左叶子之和
 */
public class T404_LeftLeavesSum {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }
        int leftChildrenValue = sumOfLeftLeaves(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftChildrenValue = root.left.val;
        }
        int rightChildrenValue = sumOfLeftLeaves(root.right);

        int sum = leftChildrenValue + rightChildrenValue;
        return sum;
    }

    /**
     * 计算二叉树中左叶子节点的和
     * @param root 二叉树的根节点
     * @return 左叶子节点的和
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        // 如果根节点为空或者根节点的左子节点和右子节点都为空，则返回0
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }
        int leftChildrenValue = 0;
        // 如果根节点的左子节点不为空，并且左子节点的左子节点和右子节点都为空，则将左子节点的值赋给leftChildrenValue
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftChildrenValue = root.left.val;
        }

        // 返回左叶子节点的和，递归调用root的左子树和右子树
        return leftChildrenValue + sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right);
    }



}
