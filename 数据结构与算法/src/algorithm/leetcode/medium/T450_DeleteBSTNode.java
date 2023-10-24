package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/10/21 10:21 星期六
 * @title 450-删除二叉搜索树中的结点
 */
public class T450_DeleteBSTNode {
    // 删除指定值的节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) { // 如果根节点为空，直接返回null
            return null;
        }

        TreeNode parent = null; // 记录当前节点的父节点
        TreeNode current = root; // 从根节点开始查找要删除的节点

        // 查找要删除的节点
        while (current != null && current.val != key) { // 当当前节点不为空且当前节点的值不等于要删除的值时，继续查找
            parent = current; // 更新父节点
            if (key < current.val) { // 如果要删除的值小于当前节点的值，向左子树查找
                current = current.left;
            } else { // 否则向右子树查找
                current = current.right;
            }
        }

        // 如果找不到要删除的节点，直接返回原树
        if (current == null) {
            return root;
        }

        // 如果当前节点没有左子树，直接用右子树替换当前节点
        if (current.left == null) {
            if (parent == null) { // 如果当前节点是根节点，直接返回右子树
                return current.right;
            } else if (parent.left == current) { // 如果当前节点是其父节点的左子节点，将其父节点的左子节点指向右子树
                parent.left = current.right;
            } else { // 如果当前节点是其父节点的右子节点，将其父节点的右子节点指向右子树
                parent.right = current.right;
            }
        }
        // 如果当前节点没有右子树，直接用左子树替换当前节点
        else if (current.right == null) {
            if (parent == null) { // 如果当前节点是根节点，直接返回左子树
                return current.left;
            } else if (parent.left == current) { // 如果当前节点是其父节点的左子节点，将其父节点的左子节点指向左子树
                parent.left = current.left;
            } else { // 如果当前节点是其父节点的右子节点，将其父节点的右子节点指向左子树
                parent.right = current.left;
            }
        } else {
            // 如果当前节点既有左子树又有右子树，找到右子树中的最小节点替换当前节点，并删除右子树中的最小节点
            TreeNode minNode = findMin(current.right); // 调用findMin方法找到右子树中的最小节点
            current.val = minNode.val; // 将当前节点的值替换为最小节点的值
            current.right = deleteNode(current.right, minNode.val); // 递归地删除右子树中的最小节点
        }

        return root; // 返回修改后的根节点
    }

    // 查找以给定节点为根的子树中的最小节点
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) { // 当当前节点的左子节点不为空时，继续向左子树查找
            node = node.left; // 更新当前节点为左子节点
        }
        return node; // 返回找到的最小节点
    }
}
