package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/11/28 17:53 星期二
 * @title 最大二叉树
 */
public class T654_MaxBinaryTree {
    /**
     * 构建最大二叉树
     * @param nums  输入的整数数组
     * @return 构建完成的最大二叉树的根节点
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    /**
     * 递归构建二叉搜索树
     * @param nums  输入数组
     * @param left  当前递归范围的左边界
     * @param right 当前递归范围的右边界
     * @return 二叉搜索树的根节点
     */
    private TreeNode build(int[] nums, int left, int right) {
        // 如果当前递归范围内没有元素，返回null
        if (right - left < 1) {
            return null;
        }
        // 如果当前递归范围内只有一个元素，创建一个只有根节点的二叉树并返回
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }

        // 在当前范围内找到最大值和对应的索引
        int maxIndex = left;
        int maxValue = nums[maxIndex];
        for (int i = left + 1; i < right; i++) {
            if (maxValue < nums[i]) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        // 创建根节点，将最大值作为根节点的值
        TreeNode root = new TreeNode(maxValue);

        // 递归构建左子树和右子树
        // 左子树范围是从当前范围的左边界到最大值的索引（不包括最大值）
        root.left = build(nums, left, maxIndex);
        // 右子树范围是从最大值的索引+1到当前范围的右边界
        root.right = build(nums, maxIndex + 1, right);

        // 返回构建好的最大二叉树的根节点
        return root;
    }

}
