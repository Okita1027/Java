package datastructure.tree;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/10/30 20:43 星期一
 * @title B树
 */
public class BTree {
    static class Node {
        int[] keys; // 关键字
        Node[] children; // 孩子
        int keyNumber; // 有效关键字数目
        boolean leaf = true; // 是否是叶子节点
        int t; // 最小度数 (最小孩子数)
        public Node(int t) { // t>=2
            this.t = t;
            this.children = new Node[2 * t];
            this.keys = new int[2 * t - 1];
        }
        public Node(int[] keys) {
            this.keys = keys;
        }
        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, keyNumber));
        }
        // 多路查找
        Node get(int key) {
            int i = 0;
            while (i < keyNumber) {
                if (keys[i] == key) {
                    return this;
                }
                if (keys[i] > key) {
                    break;
                }
                i++;
            }
            // 执行到此时 keys[i]>key 或 i==keyNumber
            if (leaf) {
                return null;
            }
            // 非叶子情况
            return children[i].get(key);
        }
        // 向 keys 指定索引处插入 key
        void insertKey(int key, int index) {
            System.arraycopy(keys, index, keys, index + 1, keyNumber - index);
            keys[index] = key;
            keyNumber++;
        }
        // 向 children 指定索引处插入 child
        void insertChild(Node child, int index) {
            System.arraycopy(children, index, children, index + 1, keyNumber -
                    index);
            children[index] = child;
        }
        int removeKey(int index) {
            int t = keys[index];
            System.arraycopy(keys, index + 1, keys, index, --keyNumber - index);
            return t;
        }
        int removeLeftmostKey() {
            return removeKey(0);
        }
        int removeRightmostKey() {
            return removeKey(keyNumber - 1);
        }
        Node removeChild(int index) {
            Node t = children[index];
            System.arraycopy(children, index + 1, children, index, keyNumber -
                    index);
            children[keyNumber] = null;
            return t;
        }
        Node removeLeftmostChild() {
            return removeChild(0);
        }
        Node removeRightmostChild() {
            return removeChild(keyNumber);
        }
        void moveToLeft(Node left) {
            int start = left.keyNumber;
            if (!leaf) {
                for (int i = 0; i <= keyNumber; i++) {
                    left.children[start + i] = children[i];
                }
            }
            for (int i = 0; i < keyNumber; i++) {
                left.keys[left.keyNumber++] = keys[i];
            }
        }
        Node leftSibling(int index) {
            return index > 0 ? children[index - 1] : null;
        }
        Node rightSibling(int index) {
            return index == keyNumber ? null : children[index + 1];
        }
    }
    Node root;
    int t; // 树中节点最小度数
    final int MIN_KEY_NUMBER; // 最小key数目
    final int MAX_KEY_NUMBER; // 最大key数目
    public BTree() {
        this(2);
    }
    public BTree(int t) {
        this.t = t;
        root = new Node(t);
        MAX_KEY_NUMBER = 2 * t - 1;
        MIN_KEY_NUMBER = t - 1;
    }
    // 1. 是否存在
    public boolean contains(int key) {
        return root.get(key) != null;
    }
    // 2. 新增
    public void put(int key) {
        doPut(root, key, null, 0);
    }
    private void doPut(Node node, int key, Node parent, int index) {
        int i = 0;
        while (i < node.keyNumber) {
            if (node.keys[i] == key) {
                return; // 更新
            }
            if (node.keys[i] > key) {
                break; // 找到了插入位置，即为此时的 i
            }
            i++;
        }
        if (node.leaf) {
            node.insertKey(key, i);
        } else {
            doPut(node.children[i], key, node, i);
        }
        if (node.keyNumber == MAX_KEY_NUMBER) {
            split(node, parent, index);
        }
    }
    /**
     * 分裂方法
     * @param left 要分裂的节点
     * @param parent 分裂节点的父节点
     * @param index 分裂节点是第几个孩子
     */
    void split(Node left, Node parent, int index) {
        // 分裂的是根节点
        if (parent == null) {
            Node newRoot = new Node(t);
            newRoot.leaf = false;
            newRoot.insertChild(left, 0);
            this.root = newRoot;
            parent = newRoot;
        }
        // 1. 创建 right 节点，把 left 中 t 之后的 key 和 child 移动过去
        Node right = new Node(t);
        right.leaf = left.leaf;
        System.arraycopy(left.keys, t, right.keys, 0, t - 1);
        // 分裂节点是非叶子的情况
        if (!left.leaf) {
            System.arraycopy(left.children, t, right.children, 0, t);
            for (int i = t; i <= left.keyNumber; i++) {
                left.children[i] = null;
            }
        }
        right.keyNumber = t - 1;
        left.keyNumber = t - 1;
        // 2. 中间的 key （t-1 处）插入到父节点
        int mid = left.keys[t - 1];
        parent.insertKey(mid, index);
        // 3. right 节点作为父节点的孩子
        parent.insertChild(right, index + 1);
    }
    // 3. 删除
    public void remove(int key) {
        doRemove(root, key, null, 0);
    }
    private void doRemove(Node node, int key, Node parent, int index) {
        int i = 0;
        while (i < node.keyNumber) {
            if (node.keys[i] >= key) {
                break;
            }
            i++;
        }
        if (node.leaf) {
            if (notFound(node, key, i)) { // case 1
                return;
            }
            node.removeKey(i); // case 2
        } else {
            if (notFound(node, key, i)) { // case 3
                doRemove(node.children[i], key, node, i);
            } else { // case 4
                Node s = node.children[i + 1];
                while (!s.leaf) {
                    s = s.children[0];
                }
                int k = s.keys[0];
                node.keys[i] = k;
                doRemove(node.children[i + 1], k, node, i + 1);
            }
        }
        if (node.keyNumber < MIN_KEY_NUMBER) { // case 5
            balance(node, parent, index);
        }
    }
    private boolean notFound(Node node, int key, int i) {
        return i >= node.keyNumber || (i < node.keyNumber && node.keys[i] !=
                key);
    }
    private void balance(Node node, Node parent, int i) {
        if (node == root) {
            if (root.keyNumber == 0 && root.children[0] != null) {
                root = root.children[0];
            }
            return;
        }
        Node leftSibling = parent.leftSibling(i);
        Node rightSibling = parent.rightSibling(i);
        if (leftSibling != null && leftSibling.keyNumber > MIN_KEY_NUMBER) {
            rightRotate(node, leftSibling, parent, i);
            return;
        }
        if (rightSibling != null && rightSibling.keyNumber > MIN_KEY_NUMBER) {
            leftRotate(node, rightSibling, parent, i);
            return;
        }
        if (leftSibling != null) {
            mergeToLeft(leftSibling, parent, i - 1);
        } else {
            mergeToLeft(node, parent, i);
        }
    }
    private void mergeToLeft(Node left, Node parent, int i) {
        Node right = parent.removeChild(i + 1);
        left.insertKey(parent.removeKey(i), left.keyNumber);
        right.moveToLeft(left);
    }
    private void rightRotate(Node node, Node leftSibling, Node parent, int i) {
        node.insertKey(parent.keys[i - 1], 0);
        if (!leftSibling.leaf) {
            node.insertChild(leftSibling.removeRightmostChild(), 0);
        }
        parent.keys[i - 1] = leftSibling.removeRightmostKey();
    }
    private void leftRotate(Node node, Node rightSibling, Node parent, int i) {
        node.insertKey(parent.keys[i], node.keyNumber);
        if (!rightSibling.leaf) {
            node.insertChild(rightSibling.removeLeftmostChild(), node.keyNumber
                    + 1);
        }
        parent.keys[i] = rightSibling.removeLeftmostKey();
    }
}