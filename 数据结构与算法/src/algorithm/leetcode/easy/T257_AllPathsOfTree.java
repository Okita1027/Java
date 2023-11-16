package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qzy
 * @time 2023/11/16 10:38 星期四
 * @title 257-二叉树的所有路径
 */
public class T257_AllPathsOfTree {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        //如果是叶子节点，说明找到了一条路径，把它加入到res中
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        //如果不是叶子节点，分别遍历他的左右子节点
        dfs(root.left, path, res);
        dfs(root.right, path, res);
    }
}
