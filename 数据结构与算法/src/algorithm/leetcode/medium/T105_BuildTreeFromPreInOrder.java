package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/10/19 15:10 星期四
 * @title 105-从前序与中序遍历序列构造二叉树
 */
public class T105_BuildTreeFromPreInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 创建根节点,根据前序遍历序列的第一个元素
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        // 区分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                // 0 ~ i-1 左子树
                // i+1 ~ inorder.length - 1 右子树
                // 划分中序序列，找到左子树和右子树的序列
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);   // [9]
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length); // [15,20,7]
                // 划分前序序列，与中序序列对应
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1); //[9]
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, inorder.length);   //[20,15,7]

                // 递归构建左子树和右子树
                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
                break;
            }
        }
        return root;
    }
}
