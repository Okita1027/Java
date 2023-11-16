package datastructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qzy
 * @time 2023/11/11 17:50 星期六
 * @title 最短路径算法（迪克斯特拉算法）
 * 算法描述：
 * 1. 将所有顶点标记为未访问。创建一个未访问顶点的集合。
 * 2. 为每个顶点分配一个临时距离值
 * 对于我们的初始顶点，将其设置为零
 * 对于所有其他顶点，将其设置为无穷大。
 * 3. 每次选择最小临时距离的未访问顶点，作为新的当前顶点
 * 4. 对于当前顶点，遍历其所有未访问的邻居，并更新它们的临时距离为更小
 * 例如，1->6 的距离是 14，而1->3->6 的距离是11。这时将距离更新为 11
 * 否则，将保留上次距离值
 * 5. 当前顶点的邻居处理完成后，把它从未访问集合中删除
 */
public class Dijkstra {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        v1.edges = List.of(new Edge(v3, 9), new Edge(v2, 7), new Edge(v6, 14));
        v2.edges = List.of(new Edge(v4, 15));
        v3.edges = List.of(new Edge(v4, 11), new Edge(v6, 2));
        v4.edges = List.of(new Edge(v5, 6));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5, 9));
        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6);
        dijkstra(graph, v1);
    }

    /**
     * 最短路径算法
     * @param graph 图
     * @param source 起点
     */
    private static void dijkstra(List<Vertex> graph, Vertex source) {
        ArrayList<Vertex> list = new ArrayList<>(graph);
        source.dist = 0;
        while (!list.isEmpty()) {
            // 选取当前顶点
            Vertex curr = chooseMinDistVertex(list);
            // 更新当前顶点邻居距离
            updateNeighboursDist(curr, list);
            // 移除当前顶点
            list.remove(curr);
            curr.visited = true;
        }
    }

    private static void updateNeighboursDist(Vertex curr, ArrayList<Vertex> list) {
        for (Edge edge : curr.edges) {
            Vertex linked = edge.linked;
            if (!linked.visited) {
                int dist = curr.dist + edge.weight;
                if (dist < linked.dist) {
                    linked.dist = dist;
                    linked.prev = curr; // 记录从何而来
                }
            }
        }
    }

    private static Vertex chooseMinDistVertex(ArrayList<Vertex> list) {
        Vertex min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).dist < min.dist) {
                min = list.get(i);
            }
        }
        return min;
    }


}
