package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author qzy
 * @time 2023/10/15 17:24 星期日
 * @title 二叉树的后序遍历
 */
public class T145_PostOrderTree {
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

    /**
     * 后续遍历
     * @param root 遍历的根节点
     * @return 遍历结果
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode root, ArrayList<Integer> list) {
        TreeNode current = root;
        // 用栈记录来的路线，便于后续进行回溯
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pop = null;    // 后续遍历是（左、右、根），所以要记录根这个结点
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                // peek用于记录栈顶的（根）节点
                TreeNode peek = stack.peek();
                // 如果右子节点为空或已经被访问过，说明可以访问当前根节点
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                    list.add(pop.val);
                } else {
                    current = peek.right;
                }
            }
        }
    }


/*
    //递归
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }*/

}
