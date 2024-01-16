package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/12/7 17:15 星期四
 * @title 飞地的数量
 */
public class T1020_numEnclaves {
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;
    private boolean[][] visited;

    public int numEnclaves(int[][] grid) { // 求被水包围的岛屿数量
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        // 遍历矩阵的边界，对于边界上的每个陆地格子，进行 DFS 搜索，将与该格子相连的所有陆地格子标记为已访问
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        // 遍历整个矩阵，统计没有被访问过的陆地格子的数量，即为被水包围的岛屿的数量
        int enclaves = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    public void dfs(int[][] grid, int row, int col) { // DFS 搜索
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) { // 判断边界条件和是否已经被访问
            return;
        }
        visited[row][col] = true; // 标记为已访问
        for (int[] dir : dirs) { // 遍历四个方向
            dfs(grid, row + dir[0], col + dir[1]); // 递归搜索
        }
    }
}

