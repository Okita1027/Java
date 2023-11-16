package datastructure.graph;

/**
 * @author qzy
 * @time 2023/11/11 11:41 星期六
 * @title 图-边
 */
public class Edge {

    /**
     * 边指向的顶点
     */
    Vertex linked;
    /**
     * 边的权重
     */
    int weight;

    public Edge(Vertex linked) {
        this(linked, 1);
    }

    public Edge(Vertex linked, int weight) {
        this.linked = linked;
        this.weight = weight;
    }

}
