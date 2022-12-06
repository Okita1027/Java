package datastructure.graph;

import datastructure.queue.LinkedQueue;

/**
 * @author Administrator
 * @Date 2022/6/11 18:58 星期六
 * 无向图，各顶点之间的连接线没有方向的概念
 */
public class Graph {
    //顶点数目
    private final int V;
    //边的数目
    private int E;
    //邻接表
    private LinkedQueue<Integer>[] adj;

    public Graph(int V) {
        //初始化顶点数量
        this.V = V;
        //初始化边的数量
        this.E = 0;
        //初始化邻接表
        this.adj = new LinkedQueue[V];
        //初始化邻接表中的空队列
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedQueue<>();
        }
    }

    //获取图中顶点的数量
    public int V() {
        return V;
    }

    //获取图中边的数量
    public int E() {
        return E;
    }

    //向图中添加一条边v-w
    public void addEdge(int v, int w) {
        //把w添加到v的链表中，这样顶点v就多了一个相邻点w
        adj[v].enQueue(w);
        //把v添加到w的链表中，这样顶点w就多了一个相邻点v
        adj[w].enQueue(v);
        //边的数目自增1
        E++;
    }

    //获取和顶点v相邻的所有顶点
    public LinkedQueue<Integer> adj(int v) {
        return adj[v];
    }
}
