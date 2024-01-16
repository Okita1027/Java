package algorithm.leetcode.medium;

/**
 * @author qzy
 * @time 2023/12/7 17:26 星期四
 * @title 岛屿数量
 */
public class T200_numIslands {
    public int numIslands(char[][] grid) {
        int res = 0; //记录找到的岛屿数量
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                //找到“1”，res加一，同时淹没这个岛
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    //使用DFS“淹没”岛屿
    public void dfs(char[][] grid, int i, int j){
        //搜索边界：索引越界或遍历到了"0"
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        //将这块土地标记为"0"
        grid[i][j] = '0';
        //根据"每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成"，对上下左右的相邻顶点进行dfs
        dfs(grid,i - 1,j);
        dfs(grid,i + 1,j);
        dfs(grid,i,j + 1);
        dfs(grid,i,j - 1);
    }
}
