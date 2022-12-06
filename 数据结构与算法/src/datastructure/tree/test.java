package datastructure.tree;

/**
 * @time 2022/6/9 20:59 星期四
 */
public class test {
    public static void main(String[] args) {
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();
        tree.put(1, 1);
        tree.put(3, 3);
        tree.put(2, 2);
        System.out.println("tree.size() = " + tree.size());
        System.out.println("tree.get(1) = " + tree.get(1));
        System.out.println("tree.get(2) = " + tree.get(2));
        System.out.println("tree.get(3) = " + tree.get(3));
    }
}
