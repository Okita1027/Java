package datastructure.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author qzy
 * @time 2023/11/11 13:38 星期六
 * @title 图-深度优先遍历
 */
public class DFS {
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

        dfs(v1);
    }

    public static void dfs(Vertex vertex) {
        vertex.visited = true;
        System.out.print(vertex.name + "->");
        for (Edge edge : vertex.edges) {
            if (!edge.linked.visited) {
                dfs(edge.linked);
            }
        }
    }

    private static void dfs2(Vertex v) {
        LinkedList<Vertex> stack = new LinkedList<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            Vertex pop = stack.pop();
            pop.visited = true;
            System.out.println(pop.name);
            for (Edge edge : pop.edges) {
                if (!edge.linked.visited) {
                    stack.push(edge.linked);
                }
            }
        }
    }
}
