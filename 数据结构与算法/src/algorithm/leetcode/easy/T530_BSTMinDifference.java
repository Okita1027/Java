package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qzy
 * @time 2023/11/29 11:33 星期三
 * @title 二叉搜索树的最小绝对差值
 */
public class T530_BSTMinDifference {
    /**
     * 获取二叉搜索树中节点值的最小差值
     *
     * @param root 二叉搜索树的根节点
     * @return 节点值的最小差值
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>(); // 用于存储二叉搜索树节点值的列表
        inorderTraversal(root, values); // 中序遍历二叉搜索树，将节点值存入列表
        int minDiff = Integer.MAX_VALUE; // 初始化最小差值为最大整数值

        // 计算相邻节点值之间的最小差值
        for (int i = 1; i < values.size(); i++) {
            int diff = values.get(i) - values.get(i - 1);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    /**
     * 中序遍历二叉搜索树，将节点值存入列表
     *
     * @param node   当前节点
     * @param values 存储节点值的列表
     */
    private void inorderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, values); // 遍历左子树
        values.add(node.val); // 将当前节点值添加到列表
        inorderTraversal(node.right, values); // 遍历右子树
    }


}
