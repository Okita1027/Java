package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author qzy
 * @time 2023/11/23 14:17 星期四
 * @title 找树左下角的值
 */
public class T513_FindBottomLeftValue {
    /**
     * 寻找二叉树最底下一个左叶节点的值
     * @param root 二叉树的根节点
     * @return 最底下一个左叶节点的值
     */
    public int findBottomLeftValue(TreeNode root) {
        int result = root.val;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    result = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return result;
    }
}
