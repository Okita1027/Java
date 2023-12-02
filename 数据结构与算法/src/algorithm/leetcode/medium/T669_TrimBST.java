package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/11/30 10:58 星期四
 * @title 修剪二叉树
 */
public class T669_TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 如果当前节点为空，则返回null
        if (root == null) {
            return null;
        }
        // 如果当前节点值小于范围最小值low，
        // 则递归修剪右子树，因为右子树节点的值都大于当前节点值
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        // 如果当前节点值大于范围最大值high，
        // 则递归修剪左子树，因为左子树节点的值都小于当前节点值
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // 如果当前节点值在范围[low, high]内，
        // 则递归修剪左右子树，并重新赋值给当前节点的左右子树
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        // 返回修剪后的根节点
        return root;
    }

}
