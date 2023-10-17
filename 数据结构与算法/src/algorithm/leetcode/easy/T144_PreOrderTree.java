package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author qzy
 * @time 2023/10/15 16:19 星期日
 * @title 144-二叉树的前序遍历
 */
public class T144_PreOrderTree {
     private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

     // 迭代实现
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(TreeNode node, List<Integer> list) {
        TreeNode current = node;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                list.add(current.val);
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop().right;
            }
        }
    }


/*     // 递归实现
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private static void preOrder(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }*/
}
