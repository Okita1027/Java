package pattern.structor.combination;

/**
 * @Author qzy
 * @ClassName Item
 * @Description 叶子节点（Leaf）：
 * 叶子节点对象，其下再无分支，是系统层次遍历的最小单位。
 * @Date 2022/12/21 16:09 星期三
 */
public class Item extends MenuComponent{
    public Item(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("---");
        }
        System.out.println(name);
    }
}
