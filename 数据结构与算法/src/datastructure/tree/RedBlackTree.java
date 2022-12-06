package datastructure.tree;

/**
 * @time 2022/6/9 9:22 星期四
 * 红黑树
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int N;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    public int size() {
        return N;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    //左旋
    private Node rotateLeft(Node h) {
        //记录X节点（h的右子节点）
        Node x = h.right;
        //1.让x的左子结点变为h的右子结点
        h.right = x.left;
        //2.让h成为x的左子结点
        x.left = h;
        //3.让h的color属性变为x的color属性值
        x.color = h.color;
        //4.让h的color属性变为RED
        h.color = RED;
        return x;
    }

    //右旋
    private Node rotateRight(Node h) {
        //记录X节点（h的左子节点）
        Node x = h.left;
        //1. 让x的右子结点成为h的左子结点
        h.left = x.right;
        //2. 让h成为x的右子结点
        x.right = h;
        //3. 让x的color变为h的color属性值
        x.color = h.color;
        //4. 让h的color为RED
        h.color = RED;
        return x;
    }

    //颜色反转
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            N++;
            return new Node(key, value, null, null, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        return h;
    }

    //根据key，从树中找出对应的值
    public Value get(Key key) {
        return get(root, key);
    }

    //从指定的树x中，查找key对应的值
    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            //如果要查询的key小于当前节点的key，则继续找当前节点的左子节点
            return get(x.left, key);
        } else if (cmp > 0) {
            //如果要查询的key大于当前节点的key，则继续找当前节点的右子节点
            return get(x.right, key);
        } else {
            return x.value;
        }
    }


}

