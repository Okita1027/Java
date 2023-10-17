package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author qzy
 * @time 2023/10/15 17:12 星期日
 * @title 二叉树的中序遍历
 */
public class T94_MidOrderTree {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        midOrder(root, list);
        return list;
    }

    private void midOrder(TreeNode root, List<Integer> list) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                current = pop.right;
            }
        }
    }

/*
    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        midOrder(root, list);
        return list;
    }

    private static void midOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        midOrder(node.left, list);
        list.add(node.val);
        midOrder(node.right, list);
    }*/
}
