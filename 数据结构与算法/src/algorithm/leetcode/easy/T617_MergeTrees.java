package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/11/29 11:25 星期三
 * @title 合并二叉树
 */
public class T617_MergeTrees {
    /**
     * 合并两棵二叉树
     *
     * @param root1 第一棵二叉树的根节点
     * @param root2 第二棵二叉树的根节点
     * @return 合并后的二叉树的根节点
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 如果第一棵二叉树为空，返回第二棵二叉树
        if (root1 == null) {
            return root2;
        }
        // 如果第二棵二叉树为空，返回第一棵二叉树
        if (root2 == null) {
            return root1;
        }
        // 将两棵二叉树对应节点的值相加
        root1.val += root2.val;
        // 递归合并左子树
        root1.left = mergeTrees(root1.left, root2.left);
        // 递归合并右子树
        root1.right = mergeTrees(root1.right, root2.right);
        // 返回合并后的二叉树的根节点
        return root1;
    }

}
