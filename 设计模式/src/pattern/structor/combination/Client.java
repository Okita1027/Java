package pattern.structor.combination;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 组合模式测试类
 * @Date 2022/12/21 16:11 星期三
 */
public class Client {
    public static void main(String[] args) {
        Menu tree = new Menu("一级目录-总目录", 1);

        Menu node1 = new Menu("二级目录-管理员", 2);
        Menu node2 = new Menu("二级目录-消费者", 2);
        Menu node3 = new Menu("二级目录-游客", 2);

        Item leaf1 = new Item("三级标签-系统管理", 3);
        Item leaf2 = new Item("三级标签-账号管理", 3);

        Item leaf3 = new Item("三级标签-贫穷消费者", 3);
        Item leaf4 = new Item("三级标签-富有消费者", 3);

        Item leaf5 = new Item("三级标签-过路游客", 3);

        node1.add(leaf1);
        node1.add(leaf2);

        node2.add(leaf3);
        node2.add(leaf4);

        node3.add(leaf5);

        tree.add(node1);
        tree.add(node2);
        tree.add(node3);

        tree.print();

    }
}