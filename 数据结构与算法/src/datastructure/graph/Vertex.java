package datastructure.graph;

import java.util.List;

/**
 * @author qzy
 * @time 2023/11/11 11:41 星期六
 * @title 图-顶点类
 */
public class Vertex {
    /**
     * 顶点名称
     */
    String name;
    /**
     * 顶点连接的边
     */
    List<Edge> edges;

    // 拓扑排序相关
    int inDegree;   // 入度
    int status; // 状态 0-未访问 1-访问中 2-访问过，用在拓扑排序

    // BFS, DFS 相关
    boolean visited;

    // 求解最短距离相关
    private static final int INF = Integer.MAX_VALUE;
    int dist = INF; // 默认距离值为无限大
    Vertex prev = null;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
