package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/11/30 11:02 星期四
 * @title 有序数组转为二叉搜索树
 */
public class T108_SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
    }

    /**
     * 构建二叉搜索树
     * @param nums 有序数组
     * @param left 数组左边界（包含）
     * @param right 数组右边界（不包含）
     * @return 构建的二叉搜索树的根节点
     */
    private TreeNode build(int[] nums, int left, int right) {
        // 递归终止条件：当左边界大于或等于右边界时，说明已经没有元素需要处理，返回null
        if (left >= right) {
            return null;
        }
        // 计算中间位置
        int mid = (left + right) / 2;
        // 创建当前中间位置对应的节点作为根节点
        TreeNode root = new TreeNode(nums[mid]);
        // 递归构建左子树，左子树的范围是[left, mid)
        root.left = build(nums, left, mid);
        // 递归构建右子树，右子树的范围是[mid+1, right)
        root.right = build(nums, mid + 1, right);
        // 返回构建的二叉搜索树的根节点
        return root;
    }

}
