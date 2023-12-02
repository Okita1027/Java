package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/12/1 8:55 星期五
 * @title 538同1038-二叉搜索树转为累加树
 */
public class T538_BSTtoGST {
    public TreeNode convertBST(TreeNode root) {
        loop(root, 0);
        return root;
    }

    private int loop(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        // 遍历右子树，并将右子树所有节点的值累加给当前节点
        node.val += loop(node.right, sum);
        // 更新 sum，即累加和，为当前节点的值
        sum = node.val;
        // 遍历左子树，并将当前节点的值累加给左子树的所有节点
        return loop(node.left, sum);
    }
}