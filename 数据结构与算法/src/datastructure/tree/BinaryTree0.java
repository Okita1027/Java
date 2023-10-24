package datastructure.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author qzy
 * @time 2023/10/15 10:18 星期日
 * @title
 */
public class BinaryTree0 {
    TreeNode0 root;

    public BinaryTree0(TreeNode0 root) {
        this.root = root;
    }

    /**
     * 通用的前、中、后序遍历
     *
     * @param node 根节点
     */
    public void commonOrderLoop(TreeNode0 node) {
        TreeNode0 current = node;
        TreeNode0 pop = null;
        Stack<TreeNode0> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            // 待处理的左子树
            if (current != null) {
                stack.push(current);
                System.out.print("\033[31m前序：" + current.value + "\033[0m");
                current = current.left;
            } else {
                TreeNode0 peek = stack.peek();
                if (peek.right == null) {   // 没有右子树
                    System.out.print("\033[32m中序：" + peek.value + "\033[0m");
                    pop = stack.pop();
                    System.out.print("\033[33m后序：" + pop.value + "\033[0m");
                } else if (peek.right == pop) { // 右子树处理完成
                    pop = stack.pop();
                    System.out.print("\033[33m后序：" + pop.value + "\033[0m");
                } else {    // 待处理右子树
                    System.out.print("\033[32m中序：" + peek.value + "\033[0m");
                    current = peek.right;
                }
            }
        }
    }

    /**
     * 循环实现前序遍历
     *
     * @param node 根节点
     */
    public void preOrderLoop(TreeNode0 node) {
        TreeNode0 current = node;
        Stack<TreeNode0> stack = new Stack<>(); // 用栈记录走过的路径
        while (current != null || !stack.isEmpty()) {
            // 当前结点还有子节点
            if (current != null) {
                stack.push(current);
                System.out.print(current.value + "\t");
                current = current.left;
            } else {
                // 当前结点没有子节点，用栈弹出上一个走过的结点（父节点）
                TreeNode0 pop = stack.pop();
                // 准备遍历父节点的右子节点
                current = pop.right;
            }
        }

    }

    /**
     * 循环实现中序遍历
     *
     * @param node 根节点
     */
    public void midOrderLoop(TreeNode0 node) {
        TreeNode0 current = node;
        Stack<TreeNode0> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode0 pop = stack.pop();
                System.out.print(pop.value + "\t");
                current = pop.right;
            }
        }
    }

    /**
     * 循环实现后序遍历
     *
     * @param node 根节点
     */
    public void postOrderLoop(TreeNode0 node) {
        TreeNode0 current = node;
        Stack<TreeNode0> stack = new Stack<>();
        TreeNode0 pop = null;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                // 不断遍历左子节点直到没有
                stack.push(current);
                current = current.left;
            } else {
                TreeNode0 peek = stack.peek();
                // 当前结点是叶子（左）节点或者上一个走过的结点的右子节点等于当前（右）结点
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                    System.out.print(pop.value + "\t");
                } else {
                    current = peek.right;
                }
            }
        }
    }

    /**
     * 递归实现前序遍历
     *
     * @param node 根节点
     */
    public void preOrderRecursion(TreeNode0 node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + "\t");
        preOrderRecursion(node.left);
        preOrderRecursion(node.right);
    }

    /**
     * 递归实现中序遍历
     *
     * @param node 根节点
     */
    public void midOrderRecursion(TreeNode0 node) {
        if (node == null) {
            return;
        }
        midOrderRecursion(node.left);
        System.out.print(node.value + "\t");
        midOrderRecursion(node.right);
    }

    /**
     * 递归实现后序遍历
     *
     * @param node 根节点
     */
    public void postOrderRecursion(TreeNode0 node) {
        if (node == null) {
            return;
        }
        postOrderRecursion(node.left);
        postOrderRecursion(node.right);
        System.out.print(node.value + "\t");
    }

    /**
     * 层序遍历
     */
    public void layerTraversal() {
        if (root == null) {
            return;
        }
        Queue<TreeNode0> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode0 poll = queue.poll();
                System.out.print(poll.value + "\t");
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            System.out.println();
        }
    }
}

class TreeNode0 {
    int value;
    TreeNode0 left;
    TreeNode0 right;

    public TreeNode0(int value) {
        this.value = value;
    }

    public TreeNode0(int value, TreeNode0 left, TreeNode0 right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
