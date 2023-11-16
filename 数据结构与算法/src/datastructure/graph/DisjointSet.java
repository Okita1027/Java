package datastructure.graph;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/11/14 15:38 星期二
 * @title 克鲁斯卡尔算法 辅助 并查集
 */
public class DisjointSet {
    int[] s;
    int[] size;
    // 索引对应顶点
    // 元素是用来表示与之有关系的顶点
    /*
        索引 0 1 2 3 4 5 6
        元素 [0, 1, 2, 3, 4, 5, 6] 表示一开始顶点直接没有联系（只与自己有联系）
     */
    public DisjointSet(int size) {
        s = new int[size];
        this.size = new int[size];
        for (int i = 0; i < size; i++) {
            s[i] = i;
            this.size[i] = 1;
        }
    }

    // find 是找到老大
    public int find(int x) { // x = 2
        if (x == s[x]) {
            return x;
        }
        return s[x] = find(s[x]); // 0 s[2]=0
    }

    // union 是让两个集合“相交”，即选出新老大，x、y 是原老大索引
    public void union(int x, int y) {
        if (size[x] < size[y]) {
            int t = x;
            x = y;
            y = t;
        }
        s[y] = x;
        size[x] = size[x] + size[y];
    }

    @Override
    public String toString() {
        return Arrays.toString(s);
    }

}
