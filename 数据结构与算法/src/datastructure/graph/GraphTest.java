package datastructure.graph;

/**
 * @Date 2022/6/12 14:37 星期日
 */
public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(3,0);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 1);
        System.out.println("depthFirstSearch.count(1) = " + depthFirstSearch.count());
    }
}
