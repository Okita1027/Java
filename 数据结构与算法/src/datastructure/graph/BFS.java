package datastructure.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author qzy
 * @time 2023/11/11 14:19 星期六
 * @title 图-广度优先搜索
 */
public class BFS {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("V1");
        Vertex v2 = new Vertex("V2");
        Vertex v3 = new Vertex("V3");
        Vertex v4 = new Vertex("V4");
        Vertex v5 = new Vertex("V5");
        Vertex v6 = new Vertex("V6");
        v1.edges = List.of(
                new Edge(v6, 14),
                new Edge(v2, 7),
                new Edge(v3, 11));
        v2.edges = List.of(new Edge(v4, 15));
        v3.edges = List.of(new Edge(v4, 11),
                new Edge(v6, 6));
        v4.edges = List.of(new Edge(v5, 6));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5, 9));

        bfs(v1);
    }

    private static void bfs(Vertex v1) {
        LinkedList<Vertex> queue = new LinkedList<>();
        v1.visited = true;
        queue.offer(v1);
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.println(current.name);
            for (Edge edge : current.edges) {
                if (!edge.linked.visited) {
                    queue.offer(edge.linked);
                    edge.linked.visited = true;
                }
            }
        }
    }
}
