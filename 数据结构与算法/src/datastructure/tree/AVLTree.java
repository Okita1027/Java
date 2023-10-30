package datastructure.tree;

/**
 * @author qzy
 * @time 2023/10/24 16:43 星期二
 * @title 平衡树
 */
public class AVLTree<K extends Comparable<K>, V> {

    AVLNode<K, V> root;

    /**
     * 平衡树节点类
     * @param <K> key-键
     * @param <V> value-值
     */
    private static class AVLNode<K, V> {
        K key;
        V value;
        AVLNode<K, V> left;
        AVLNode<K, V> right;
        int height;

        public AVLNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 求结点高度
     * @param node 结点
     * @return 高度
     */
    private int height(AVLNode<K, V> node) {
        return node == null ? 0 : node.height;
    }
    /**
     * 更新结点高度
     * @param node 结点
     */
    private void updateHeight(AVLNode<K, V> node) {
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }
    /**
     * 平衡因子
     * @param node 结点
     * @return 左右子树高度的差值
     */
    private int balanceFactor(AVLNode<K, V> node) {
        return height(node.left) - height(node.right);
    }

    /**
     * 左旋
     * @param root 要旋转的根节点
     * @return 旋转后的根节点
     */
    public AVLNode<K, V> leftRotate(AVLNode<K, V> root) {
        AVLNode<K, V> son = root.right;
        root.right = son.left;
        son.left = root;
        updateHeight(root);
        updateHeight(son);
        return son;
    }

    /**
     * 右旋
     * @param root 要旋转的根节点
     * @return 旋转后的根节点
     */
    public AVLNode<K, V> rightRotate(AVLNode<K, V> root) {
        AVLNode<K, V> son = root.left;
        root.left = son.right;
        son.right = root;
        updateHeight(root);
        updateHeight(son);
        return son;
    }


    /**
     * 先左旋再右旋
     * @param root 要旋转的根节点
     * @return 旋转后的根节点
     */
    public AVLNode<K, V> leftRightRotate(AVLNode<K, V> root) {
        root.left = leftRotate(root);
        return rightRotate(root);
    }

    /**
     * 先左旋再右旋
     * @param root 要旋转的根节点
     * @return 旋转后的根节点
     */
    public AVLNode<K, V> rightLeftRotate(AVLNode<K, V> root) {
        root.right = rightRotate(root);
        return leftRotate(root);
    }

    /**
     * 调整不平衡的树
     * @param node 当前结点
     * @return 平衡后的结点
     */
    private AVLNode<K, V> balance(AVLNode<K, V> node) {
        if (node == null)
            return null;
        int bf = balanceFactor(node);
        if (bf > 1 && balanceFactor(node.left) >= 0) {   // LL
            return rightRotate(node);
        } else if (bf > 1 && balanceFactor(node.left) < 0) {    // LR
            return leftRightRotate(node);
        } else if (bf < -1 && balanceFactor(node.right) > 0) {  // RL
            return rightLeftRotate(node);
        } else if (bf < -1 && balanceFactor(node.right) <= 0) {  // RR
            return leftRotate(node);
        }
        return node;
    }

    /**
     * 添加元素
     * @param key 键
     * @param value 值
     */
    public void put(K key, V value) {
        root = doPut(root, key, value);
    }

    private AVLNode<K, V> doPut(AVLNode<K, V> node, K key, V value) {
        // 1.找到空位，创建新节点
        if (node == null) {
            return new AVLNode<>(key, value);
        }
        // 2.key已存在，更新
        if (node.key.compareTo(key) == 0) {
            node.value = value;
            return node;
        }
        // 3.继续查找
        if (key.compareTo(node.key) < 0) {
            node.left = doPut(node.left, key, value);
        } else {
            node.right = doPut(node.right, key, value);
        }
        updateHeight(node);
        return balance(node);
    }

    /**
     * 删除结点
     * @param key 结点的KEY值
     */
    public void remove(K key) {
        root = doRemove(root, key);
    }

    private AVLNode<K, V> doRemove(AVLNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        // 如果要删除的键小于当前节点的键，则继续在左子树中删除
        if (key.compareTo(node.key) < 0) {
            node.left = doRemove(node.left, key);
        }
        // 如果要删除的键大于当前节点的键，则继续在右子树中删除
        else if (key.compareTo(node.key) > 0) {
            node.right = doRemove(node.right, key);
        }
        // 找到了要删除的节点
        else {
            // 如果要删除的节点没有左子树，则直接用右子树替代要删除的节点
            if (node.left == null) {
                node = node.right;
            }
            // 如果要删除的节点没有右子树，则直接用左子树替代要删除的节点
            else if (node.right == null) {
                node = node.left;
            }
            // 如果要删除的节点既有左子树又有右子树
            else {
                // 找到要删除节点的后继节点（右子树中最小的节点）
                AVLNode<K, V> successor = node.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                // 将后继节点从右子树中删除，并将其替代要删除的节点
                successor.right = doRemove(node.right, successor.key);
                successor.left = node.left;
                node = successor;
            }
        }
        // 更新节点的高度
        if (node == null) {
            return null;
        }
        updateHeight(node);
        // 平衡化节点
        return balance(node);
    }

}
