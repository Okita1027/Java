package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/9/19 9:26 星期二
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 */
public class T59 {

    public int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];
        int current = 1, target = n * n;
        int horizontal, vertical;
        horizontal = vertical = 0;

        while (current <= target) {

            current++;
        }

        return array;
    }

    public static void main(String[] args) {

    }
}
