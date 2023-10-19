package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/10/19 11:25 星期四
 * @title 226-翻转二叉树
 */
public class T226_ReverseTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null && root.right != null) {
            invertTree(root.left);
            invertTree(root.right);
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }


}
