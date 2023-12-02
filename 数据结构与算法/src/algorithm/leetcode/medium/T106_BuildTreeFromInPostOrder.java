package algorithm.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qzy
 * @time 2023/10/19 16:18 星期四
 * @title 106-从中序与后续遍历序列构造二叉树
 */
public class T106_BuildTreeFromInPostOrder {
    // 黑马程序员
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                int[] postLeft = Arrays.copyOfRange(postorder, 0, i);
                int[] postRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);
                root.left = buildTree(inLeft, postLeft);
                root.right = buildTree(inRight, postRight);
                break;
            }
        }
        return root;
    }


    // 代码随想录
    Map<Integer, Integer> map;  // 方便根据数值查找位置
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }

        return findNode(inorder,  0, inorder.length, postorder,0, postorder.length);  // 前闭后开
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        // 参数里的范围都是前闭后开
        if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }
        int rootIndex = map.get(postorder[postEnd - 1]);  // 找到后序遍历的最后一个元素在中序遍历中的位置
        TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点
        int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定后序数列的个数
        root.left = findNode(inorder, inBegin, rootIndex,
                postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd,
                postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }



    // Chat-GPT
        /**
     * 通过后序遍历和中序遍历构建二叉树
     * @param inorder 中序遍历结果
     * @param postorder 后序遍历结果
     * @return 构建的二叉树的根节点
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * 递归构建二叉树的辅助方法
     * @param inorder 中序遍历结果
     * @param inStart 中序遍历的起始位置
     * @param inEnd 中序遍历的结束位置
     * @param postorder 后序遍历结果
     * @param postStart 后序遍历的起始位置
     * @param postEnd 后序遍历的结束位置
     * @return 构建的二叉树的根节点
     */
    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // 根节点值为后序遍历的最后一个节点
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndexInorder = 0;

        // 在中序遍历中找到根节点的位置
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndexInorder = i;
                break;
            }
        }

        // 计算左子树的大小
        int leftSize = rootIndexInorder - inStart;
        // 计算右子树的大小
        int rightSize = inEnd - rootIndexInorder;

        // 递归构建左子树
        root.left = buildTreeHelper(inorder, inStart, rootIndexInorder - 1, postorder, postStart, postStart + leftSize - 1);
        // 递归构建右子树
        root.right = buildTreeHelper(inorder, rootIndexInorder + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);

        return root;
    }


}
