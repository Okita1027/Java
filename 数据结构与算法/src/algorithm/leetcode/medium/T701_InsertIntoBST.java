package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/10/21 19:51 星期六
 * @title 701-二叉搜索树中的插入操作
 */
public class T701_InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

/*    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode current = root;
        TreeNode parent = null;
        while (current != null) {
            parent = current;
            if (val > current.val) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        if (val < parent.val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }
        return root;
    }*/
}
