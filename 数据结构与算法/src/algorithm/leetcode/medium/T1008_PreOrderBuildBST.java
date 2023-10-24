package algorithm.leetcode.medium;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author qzy
 * @time 2023/10/24 11:29 星期二
 * @title 1088-前序遍历构造二叉搜索树
 */
public class T1008_PreOrderBuildBST {
    public static void main(String[] args) {
        int[] preOrder = {8, 5, 1, 7, 10, 12};
        TreeNode root = new T1008_PreOrderBuildBST().bstFromPreorder(preOrder);

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        // [8,5,1,7,10,12]
        int[] inorder = Arrays.stream(preorder).sorted().toArray();
        return buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 创建根节点
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        // 区分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                // 0 ~ i-1 左子树
                // i+1 ~ inorder.length - 1 右子树
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);   // [9]
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length); // [15,20,7]
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1); //[9]
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, inorder.length);   //[20,15,7]

                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
                break;
            }
        }
        return root;
    }


}
