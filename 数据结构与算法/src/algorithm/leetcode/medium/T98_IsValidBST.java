package algorithm.leetcode.medium;

import java.util.ArrayList;

/**
 * @author qzy
 * @time 2023/10/21 23:34 星期六
 * @title 98-验证二叉搜索树
 */
public class T98_IsValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6, new TreeNode(3), new TreeNode(7));
        System.out.println(new T98_IsValidBST().isValidBST(root));

        root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(new T98_IsValidBST().isValidBST(root));

        root = new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(5, new TreeNode(4), new TreeNode(6)));
        System.out.println(new T98_IsValidBST().isValidBST(root));
    }
/*    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }*/


    public boolean isValidBST(TreeNode root) {
        // 中序遍历（元素从小到大）放到集合中
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        // 左边的元素一旦大于右边的元素，就认为是不合法的二叉搜索树
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中序遍历
     * @param root 根节点
     * @param list 遍历的结果
     */
    private void inOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
