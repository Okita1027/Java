package datastructure.tree;

/**
 * @time 2022/6/11 9:49 星期六
 * 并查集
 * 1. 每个元素都唯一的对应一个结点；
 * 2. 每一组数据中的多个元素都在同一颗树中；
 * 3. 一个组中的数据对应的树和另外一个组中的数据对应的树之间没有任何联系；
 * 4. 元素在树中并没有子父级关系的硬性要求；
 */
public class UnionFind {
    //记录节点元素和该元素所在的分组
    private int[] eleAndGroup;
    //记录并查集中数据的分组个数
    private int count;

    public UnionFind(int N) {
        //初始情况下，每个元素都在一个独立的分组中，所以，初始情况下，并查集中的数据默认分为N个组
        this.count = N;
        //初始化数组
        this.eleAndGroup = new int[N];
        //把eleAndGroup数组的索引看做是每个结点存储的元素，把eleAndGroup数组每个索引处的值看做是
        //该结点所在的分组，那么初始化情况下，i索引处存储的值就是i
        for (int i = 0; i < N; i++) {
            eleAndGroup[i] = i;
        }
    }

    //获取当前并查集中的数据有多少个分组
    public int count() {
        return count;
    }

    //元素p所在分组的标识符
    public int find(int p) {
        return eleAndGroup[p];
    }

    //判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //把p元素所在分组和q元素所在分组合并
    public void union(int p, int q) {
        //若p和q已经在同一分组，则无需合并
        if (connected(p, q)) {
            return;
        }
        //如果p和q不在同一个分组，则只需要将p元素所在组的所有的元素的组标识符修改为q元素所在组的标识符即可
        int pGroup = find(p);
        int qGroup = find(q);
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pGroup) {
                eleAndGroup[i] = qGroup;
            }
        }
        //分组数量-1
        count--;
    }
}
