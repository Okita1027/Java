package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/10/24 10:00 星期二
 * @title 222-树的结点个数
 */
public class T222_TreeCountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
