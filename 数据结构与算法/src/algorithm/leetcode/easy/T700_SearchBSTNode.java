package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/10/21 20:14 星期六
 * @title 700-二叉搜索树中的搜索
 */
public class T700_SearchBSTNode {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;
        while (current != null) {
            if (val > current.val) {
                current = current.right;
            } else if (val < current.val) {
                current = current.left;
            } else {
                return current;
            }
        }
        return null;
    }
}
