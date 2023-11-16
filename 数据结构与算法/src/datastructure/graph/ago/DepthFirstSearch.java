package datastructure.graph.ago;

/**
 * @author Administrator
 * @Date 2022/6/12 13:02 星期日
 * 深度优先搜索
 */
public class DepthFirstSearch {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //记录有多少个顶点与s顶点相通
    private int count;
    //构造深度优先搜索对象，使用深度优先搜索找出G图中s顶点的所有相邻顶点

    public DepthFirstSearch(Graph G, int s) {
        //创建一个和图的顶点数一样大小的布尔型数组
        this.marked = new boolean[G.V()];
        //初始化跟顶点s相同的顶点数量
        this.count = 0;
        //搜索G图中与顶点s相同的所有顶点
        dfs(G, s);
    }

    //使用深度优先搜索找出G图中v顶点的所有想通顶点
    private void dfs(Graph G, int v) {
        //把v顶点标识为已搜索
        marked[v] = true;
        //遍历v顶点的邻接表，得到每一个顶点w
        for (Object w : G.adj(v)) {
            if (!marked[(Integer) w]) {
                dfs(G, (Integer) w);
            }
        }
        //相通的顶点数量+1
        count++;
    }

    //判断w顶点与s顶点是否相通
    public boolean marked(int w) {
        return marked[w];
    }

    //获取与顶点s相通的所有顶点的总数
    public int count() {
        return count;
    }
}
