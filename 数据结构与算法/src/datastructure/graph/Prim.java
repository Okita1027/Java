package datastructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qzy
 * @time 2023/11/14 12:46 星期二
 * @title 最小生成树-Prim算法
 */
public class Prim {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");
        v1.edges = List.of(new Edge(v2, 2), new Edge(v3, 4), new Edge(v4, 1));
        v2.edges = List.of(new Edge(v1, 2), new Edge(v4, 3), new Edge(v5, 10));
        v3.edges = List.of(new Edge(v1, 4), new Edge(v4, 2), new Edge(v6, 5));
        v4.edges = List.of(new Edge(v1, 1), new Edge(v2, 3), new Edge(v3, 2),
                new Edge(v5, 7), new Edge(v6, 8), new Edge(v7, 4));
        v5.edges = List.of(new Edge(v2, 10), new Edge(v4, 7), new Edge(v7, 6));
        v6.edges = List.of(new Edge(v3, 5), new Edge(v4, 8), new Edge(v7, 1));
        v7.edges = List.of(new Edge(v4, 4), new Edge(v5, 6), new Edge(v6, 1));
        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6, v7);
        prim(graph, v1);
    }

    static void prim(List<Vertex> graph, Vertex source) {
        ArrayList<Vertex> list = new ArrayList<>(graph); // 将图中的顶点复制到列表中
        source.dist = 0; // 设置源顶点的距离为0
        while (!list.isEmpty()) { // 只要列表不为空就继续执行
            Vertex min = chooseMinDistVertex(list); // 选择列表中距离最小的顶点
            updateNeighboursDist(min); // 更新最小顶点的邻居顶点的距离
            list.remove(min); // 从列表中移除已处理过的顶点
            min.visited = true; // 标记最小顶点为已访问
            System.out.println("---------------"); // 打印分隔线
            for (Vertex v : graph) { // 遍历图中所有顶点
                System.out.println(v); // 打印顶点信息
            }
        }
    }

    private static void updateNeighboursDist(Vertex curr) {
        for (Edge edge : curr.edges) { // 遍历当前顶点的所有边
            Vertex n = edge.linked; // 获取边对应的邻居顶点
            if (!n.visited) { // 如果邻居顶点未被访问过
                int dist = edge.weight; // 获取当前边的权重作为距离（与Dijkstra算法不同）
                if (dist < n.dist) { // 如果新距离小于邻居顶点的当前距离
                    n.dist = dist; // 更新邻居顶点的距离为新距离
                    n.prev = curr; // 更新邻居顶点的前驱顶点为当前顶点
                }
            }
        }
    }

    private static Vertex chooseMinDistVertex(ArrayList<Vertex> list) {
        Vertex min = list.get(0); // 假设列表中的第一个顶点距离最小
        for (int i = 1; i < list.size(); i++) { // 遍历列表中的所有顶点
            if (list.get(i).dist < min.dist) { // 如果发现更小距离的顶点
                min = list.get(i); // 更新最小距离的顶点为新的顶点
            }
        }
        return min; // 返回距离最小的顶点
    }

}
