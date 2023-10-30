package datastructure.tree;

import static datastructure.tree.RBTree.Color.RED;
import static datastructure.tree.RBTree.Color.BLACK;

/**
 * @author qzy
 * @time 2023/10/26 19:35 星期四
 * @title 红黑树
 */
public class RBTree<K extends Comparable<K>, V> {
    enum Color {
        RED, BLACK;
    }

    Node<K, V> root;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;
        Color color = RED;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key) {
            this.key = key;
        }

        public Node(K key, Color color) {
            this.key = key;
            this.color = color;
        }

        public Node(K key, Color color, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.color = color;
            this.left = left;
            this.right = right;
            if (left != null) {
                left.parent = this;
            }
            if (right != null) {
                right.parent = this;
            }
        }

        /**
         * 当前结点是否是左孩子
         *
         * @return 是否为左孩子
         */
        boolean isLeftChild() {
            return parent != null && parent.left == this;
        }

        /**
         * 叔叔结点
         *
         * @return 爷爷结点的另外一个儿子结点
         */
        Node<K, V> uncle() {
            if (parent == null || parent.parent == null) {
                return null;
            }
            if (parent.isLeftChild()) {
                return parent.parent.right;
            } else {
                return parent.parent.left;
            }
        }

        /**
         * 兄弟结点
         *
         * @return 当前父节点的另外一个子节点
         */
        Node<K, V> sibling() {
            if (parent == null) {
                return null;
            }
            if (this.isLeftChild()) {
                return parent.right;
            } else {
                return parent.left;
            }
        }
    }

    /**
     * 是否是红色结点
     *
     * @param node 当前结点
     * @return 是否为红
     */
    boolean isRed(Node<K, V> node) {
        return node != null && node.color == RED;
    }

    /**
     * 是否是黑色结点
     *
     * @param node 当前结点
     * @return 是否为黑
     */
    boolean isBlack(Node<K, V> node) {
        return node == null || node.color == BLACK;
    }

    /**
     * 右旋
     *
     * @param node 要旋转的当前结点
     */
    private void rightRotate(Node<K, V> node) {
        Node<K, V> parent = node.parent; // 保存当前节点的父节点
        Node<K, V> leftChild = node.left; // 保存当前节点的左子节点
        Node<K, V> rightGrandChild = leftChild.right; // 保存左子节点的右子节点

        if (rightGrandChild != null) { // 如果左子节点的右子节点不为空
            rightGrandChild.parent = node; // 将右孙子节点的父节点设置为当前节点
        }

        leftChild.right = node; // 将当前节点的左子节点的右子节点指向当前节点
        leftChild.parent = node.parent; // 将当前节点的左子节点的父节点指向当前节点的父节点
        node.left = rightGrandChild; // 将当前节点的左子节点指向左子节点的右子节点
        node.parent = leftChild; // 将当前节点的父节点指向左子节点

        if (parent == null) { // 如果当前节点是根节点
            root = leftChild; // 将左子节点设置为新的根节点
        } else if (parent.left == node) { // 如果当前节点是父节点的左子节点
            parent.left = leftChild; // 将左子节点设置为父节点的左子节点
        } else { // 如果当前节点是父节点的右子节点
            parent.right = leftChild; // 将左子节点设置为父节点的右子节点
        }
    }

    /**
     * 左旋
     *
     * @param node 要旋转的结点
     */
    private void leftRotate(Node<K, V> node) {
        Node<K, V> parent = node.parent;
        Node<K, V> leftChild = node.left;
        Node<K, V> rightGrandChild = leftChild.right;

    }

    /**
     * 插入结点
     *
     * @param key   结点的KEY
     * @param value 结点的VALUE
     */
    public void put(K key, V value) {
        Node<K, V> current = root;
        Node<K, V> parent = current.parent;
        while (current != null) {
            if (current.key.compareTo(key) < 0) {
                parent = current;
                current = current.left;
            } else if (current.key.compareTo(key) > 0) {
                parent = current;
                current = current.right;
            } else {
                current.value = value;
            }
        }
        Node<K, V> inserted = new Node<>(key, value);
        if (parent == null) {
            root = inserted;
        } else if (key.compareTo(inserted.key) < 0) {
            parent.left = inserted;
            inserted.parent = parent;
        } else {
            parent.right = inserted;
            inserted.parent = parent;
        }
        fixRedRed(inserted);
    }

    /**
     * 调整（红红相邻情况）平衡
     *
     * @param x 插入的结点
     */
    private void fixRedRed(Node<K, V> x) {
        // case 1 插入节点是根节点，变黑即可
        if (x == root) {
            x.color = BLACK;
            return;
        }
        // case 2 插入节点父亲是黑色，无需调整
        if (isBlack(x.parent)) {
            return;
        }
        /* case 3 当红红相邻，叔叔为红时
            需要将父亲、叔叔变黑、祖父变红，然后对祖父做递归处理
        */
        Node<K, V> parent = x.parent;
        Node<K, V> uncle = x.uncle();
        Node<K, V> grandparent = parent.parent;
        if (isRed(uncle)) {
            parent.color = BLACK;
            uncle.color = BLACK;
            grandparent.color = RED;
            fixRedRed(grandparent);
            return;
        }
        // case 4 当红红相邻，叔叔为黑时
        if (parent.isLeftChild() && x.isLeftChild()) { // LL
            parent.color = BLACK;
            grandparent.color = RED;
            rightRotate(grandparent);
        } else if (parent.isLeftChild()) { // LR
            leftRotate(parent);
            x.color = BLACK;
            grandparent.color = RED;
            rightRotate(grandparent);
        } else if (!x.isLeftChild()) { // RR
            parent.color = BLACK;
            grandparent.color = RED;
            leftRotate(grandparent);
        } else { // RL
            rightRotate(parent);
            x.color = BLACK;
            grandparent.color = RED;
            leftRotate(grandparent);
        }
    }

    /**
     * 移除结点-正常删会用到‘李代桃僵’技巧、遇到黑黑不平衡进行调整
     *
     * @param key 结点的KEY
     */
    public void remove(K key) {
        Node<K, V> deleted = find(key);
        if (deleted == null) {
            return;
        }
        doRemove(deleted);
    }

    private void doRemove(Node<K, V> deleted) {
        Node<K, V> replaced = findReplaced(deleted);
        Node<K, V> parent = deleted.parent;
        // 没有孩子
        if (replaced == null) {
            // case 1 删除的是根节点
            if (deleted == root) {
                root = null;
            } else {
                if (isBlack(deleted)) {
                    // 双黑调整
                    fixDoubleBlack(deleted);
                } else {
                    // 红色叶子, 无需任何处理
                }
                if (deleted.isLeftChild()) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                deleted.parent = null;
            }
            return;
        }
        // 有一个孩子
        if (deleted.left == null || deleted.right == null) {
            // case 1 删除的是根节点
            if (deleted == root) {
                root.key = replaced.key;
                root.value = replaced.value;
                root.left = root.right = null;
            } else {
                if (deleted.isLeftChild()) {
                    parent.left = replaced;
                } else {
                    parent.right = replaced;
                }
                replaced.parent = parent;
                deleted.left = deleted.right = deleted.parent = null;
                if (isBlack(deleted) && isBlack(replaced)) {
                    // @TODO 实际不会有这种情况 因为只有一个孩子时 被删除节点是黑色 那么剩余节点只能是红色不会触发双黑
                    fixDoubleBlack(replaced);
                } else {
                    // case 2 删除是黑，剩下是红
                    replaced.color = BLACK;
                }
            }
            return;
        }
        // case 0 有两个孩子 => 有一个孩子 或 没有孩子
        K t = deleted.key;
        deleted.key = replaced.key;
        replaced.key = t;
        V v = deleted.value;
        deleted.value = replaced.value;
        replaced.value = v;
        doRemove(replaced);
    }

    // 处理双黑 (case3、case4、case5)
    private void fixDoubleBlack(Node<K, V> x) {
        if (x == root) {
            return;
        }
        Node<K, V> parent = x.parent;
        Node<K, V> sibling = x.sibling();
        // case 3 兄弟节点是红色
        if (isRed(sibling)) {
            if (x.isLeftChild()) {
                leftRotate(parent);
            } else {
                rightRotate(parent);
            }
            parent.color = RED;
            sibling.color = BLACK;
            fixDoubleBlack(x);
            return;
        }
        if (sibling != null) {
            // case 4 兄弟是黑色, 两个侄子也是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                sibling.color = RED;
                if (isRed(parent)) {
                    parent.color = BLACK;
                } else {
                    fixDoubleBlack(parent);
                }
            }
            // case 5 兄弟是黑色, 侄子有红色
            else {
                // LL
                if (sibling.isLeftChild() && isRed(sibling.left)) {
                    rightRotate(parent);
                    sibling.left.color = BLACK;
                    sibling.color = parent.color;
                }
                // LR
                else if (sibling.isLeftChild() && isRed(sibling.right)) {
                    sibling.right.color = parent.color;
                    leftRotate(sibling);
                    rightRotate(parent);
                }
                // RL
                else if (!sibling.isLeftChild() && isRed(sibling.left)) {
                    sibling.left.color = parent.color;
                    rightRotate(sibling);
                    leftRotate(parent);
                }
                // RR
                else {
                    leftRotate(parent);
                    sibling.right.color = BLACK;
                    sibling.color = parent.color;
                }
                parent.color = BLACK;
            }
        } else {
            // @TODO 实际也不会出现，触发双黑后，兄弟节点不会为 null
            fixDoubleBlack(parent);
        }
    }

    /**
     * 是否包含结点
     *
     * @param key 结点的KEY
     * @return 包含与否
     */
    public boolean contains(K key) {
        return find(key) != null;
    }

    /**
     * 查找删除结点
     *
     * @param key 结点的KEY
     * @return 删除结点
     */
    private Node<K, V> find(K key) {
        Node<K, V> p = root;
        while (p != null) {
            if (key.compareTo(p.key) < 0) {
                p = p.left;
            } else if (key.compareTo(p.key) > 0) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    // 查找剩余(后继)节点
    private Node<K, V> findReplaced(Node<K, V> deleted) {
        if (deleted.left == null && deleted.right == null) {
            return null;
        }
        if (deleted.left == null) {
            return deleted.right;
        }
        if (deleted.right == null) {
            return deleted.left;
        }
        Node<K, V> s = deleted.right;
        while (s.left != null) {
            s = s.left;
        }
        return s;
    }


}
