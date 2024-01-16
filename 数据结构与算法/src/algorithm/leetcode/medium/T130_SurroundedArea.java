package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/12/7 17:28 星期四
 * @title 被围绕的区域
 */
public class T130_SurroundedArea {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        // 遍历矩阵的边缘，从边缘上的 'O' 开始进行深度优先搜索（DFS）
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        // 遍历整个矩阵，将 'O' 替换为 'X'，将 '#' 替换为 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        // 判断当前位置是否越界或者已经被搜索过，如果是，则直接返回
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#'; // 将当前位置标记为 '#'

        // 递归地对当前位置的上、下、左、右四个方向进行 DFS 搜索
        dfs(board, i - 1, j); // 上
        dfs(board, i + 1, j); // 下
        dfs(board, i, j - 1); // 左
        dfs(board, i, j + 1); // 右
    }

}
