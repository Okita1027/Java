package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qzy
 * @time 2023/10/24 16:23 星期二
 * @title 235-二叉搜索树的最近公共祖先
 */
public class T235_LowestCommonAncestorBST {
/*    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }*/

    /**
     * 给定二叉树 root，找到 p、q 的最低共同祖先。
     * p 和 q 是二叉树中不同的节点。
     * 返回值为最低共同祖先的节点。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pathP = new ArrayList<TreeNode>(); // 存储 p 的路径节点
        ArrayList<TreeNode> pathQ = new ArrayList<TreeNode>(); // 存储 q 的路径节点
        find(root, p, pathP); // 找到 p 的路径节点
        find(root, q, pathQ); // 找到 q 的路径节点
        List<TreeNode> res = pathP.stream().filter(pathQ::contains).toList(); // 找到 pathP 和 pathQ 共有的节点
        return res.get(res.size() - 1); // 返回最低共同祖先节点
    }

        private void find(TreeNode root, TreeNode target, List<TreeNode> path) {
        // 将当前节点加入路径中
        path.add(root);
        // 如果当前节点等于目标节点，则返回
        if (root == target) {
            return;
        }
        // 如果目标节点的值小于当前节点的值，则在左子树中继续查找
        if (target.val < root.val) {
            find(root.left, target, path);
        }
        // 否则在右子树中继续查找
        else {
            find(root.right, target, path);
        }
    }


}
