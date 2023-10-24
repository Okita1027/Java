package datastructure.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author qzy
 * @time 2023/10/19 17:43 星期四
 * @title 二叉搜索树
 */
public class BinarySearchTree<E, T extends Comparable<T>> {
    private BSTNode<E, T> root;

    static class BSTNode<E, T> {
        T key;     // 若希望任意类型作为 key, 则后续可以将其设计为 Comparable 接口
        E value;
        BSTNode<E, T> left;
        BSTNode<E, T> right;

        public BSTNode(T key) {
            this.key = key;
        }

        public BSTNode(T key, E value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(T key, E value, BSTNode<E, T> left, BSTNode<E, T> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public BinarySearchTree() {

    }

    public BSTNode<E, T> getRoot() {
        return root;
    }

    /*
    // 递归实现
    public Object get(int key) {
        return doGet(root, key);
    }

    private Object doGet(BSTNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.key < key) {
            return doGet(node.left, key);
        } else if (node.key > key) {
            return doGet(node.left, key);
        } else {
            return node.value;
        }
    }*/

    /**
     * 查找关键字对应的值
     *
     * @param key 关键字
     * @return 对应值
     */
    public E get(T key) {
        BSTNode<E, T> node = root;
        while (node != null) {
            int result = key.compareTo(node.key);
            if (result < 0) {
                node = node.left;
            } else if (result > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    /**
     * 获取最小key所对应的值
     *
     * @return 最小key对应值
     */
    public E min() {
        if (root == null) {
            return null;
        }
        BSTNode<E, T> current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    /**
     * 获取最大key所对应的值
     *
     * @return 最大key对应值
     */
    public E max() {
        if (root == null) {
            return null;
        }
        BSTNode<E, T> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    /**
     * 存储关键字和对应值
     * @param key   关键字
     * @param value 值
     */
    public void put(T key, E value) {
        BSTNode<E, T> current = root;
        BSTNode<E, T> parent = null;
        while (current != null) {
            parent = current;
            int result = key.compareTo(current.key);
            if (result > 0) {
                current = current.right;
            } else if (result < 0) {
                current = current.left;
            } else {
                // 1. key存在则更新值
                current.value = value;
                return;
            }
        }
        // 2. key 不存在则新增
        if (parent == null) {   // 根节点不存在
            root = new BSTNode<>(key, value);
        } else if (key.compareTo(parent.key) < 0) {
            parent.left = new BSTNode<>(key, value);
        } else {
            parent.right = new BSTNode<>(key, value);
        }
    }

    /**
     * 查找指定结点的前驱结点
     *
     * @param key 指定结点的KEY值
     * @return 比KEY节点小的结点中最大的结点
     */
    public E predecessor(T key) {
        BSTNode<E, T> current = root;
        BSTNode<E, T> ancestorLeft = null;  // 祖先是从某个左子树过来的
        // 找到指定的key所对应的结点
        while (current != null) {
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                ancestorLeft = current; // 祖先结点从左向右走了
                current = current.right;
            } else {
                break;
            }
        }
        // 没有找到指定的key结点
        if (current == null) {
            return null;
        }
        // 有左子树：在该子树中找到最大值
        if (current.left != null) {
            return max(current.left);
        }
        // 无左子树：上一个从左树过来的祖先结点就是前驱结点
        return ancestorLeft != null ? ancestorLeft.value : null;
    }

    private E max(BSTNode<E, T> node) {
        if (node == null) {
            return null;
        }
        BSTNode<E, T> current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    /**
     * 找到指定结点的后驱结点
     *
     * @param key 指定的key对应的结点
     * @return 比指定节点大的结点中最小的结点
     */
    public E successor(T key) {
        BSTNode<E, T> current = root;
        BSTNode<E, T> ancestorRight = null;
        // 找到指定的key所对应的结点
        while (current != null) {
            if (key.compareTo(current.key) < 0) {
                ancestorRight = current;    // 祖先自右而来
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else {
                break;
            }
        }
        // 指定的key所对应的结点不存在
        if (current == null) {
            return null;
        }
        // 右子树不为空：从右子树中找到最小值
        if (current.right != null) {
            return min(current.right);
        }
        // 右子树为空：返回最后一次自右而来的祖先结点
        return ancestorRight != null ? ancestorRight.value : null;
    }

    private E min(BSTNode<E, T> node) {
        if (node == null) {
            return null;
        }
        BSTNode<E, T> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    /**
     * 根据关键字移除某个元素并返回值
     * @param key 指定结点的关键字
     * @return 结点的值
     */
    public E delete(T key) {
        BSTNode<E, T> current = root;
        BSTNode<E, T> parent = null;
        // 找到指定的key所对应的结点
        while (current != null) {
            if (key.compareTo(current.key) < 0) {
                parent = current;
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }
        // 指定的key对应的结点不存在
        if (current == null) {
            return null;
        }
        if (current.right == null) {    // 被删除结点只有左子树 或 左右子树都没有
            shift(parent, current, current.left);
        } else if (current.left == null) {  // 被删除结点只有右子树
            shift(parent, current, current.right);
        } else {    // 被删除的结点同时有左子树和右子树
            BSTNode<E, T> successor = current.right;    // 将要被删除结点的右子结点
            BSTNode<E, T> successorParent = current;  // 右子结点的父节点
            // 找到最终的后继结点，即被删除结点的右子树中最小的结点
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            if (successorParent != current) {   // 被删除结点与后继结点不相邻
                shift(successorParent, successor, successor.right); // 把后继结点的右子节点接到它的父节点上
                successor.right = current.right;    // 把被删除结点的右子节点接到后继结点的右子节点上
            }
            // 后继结点取代被删除结点
            shift(parent, current, successor);
            successor.left = current.left;  // 把被删除结点的左子节点接到后继结点的左子节点上
        }

        return null;
    }

    /**
     * 托孤
     *
     * @param parent  被删除结点的父结点
     * @param deleted 被删除的结点
     * @param child   被顶上去的结点
     */
    private void shift(BSTNode<E, T> parent, BSTNode<E, T> deleted, BSTNode<E, T> child) {
        // 移除的是根节点
        if (parent == null) {
            root = child;
        } else if (deleted.left != null) {
            parent.left = child;
        } else {
            parent.right = child;
        }

    }

    /*
     * 递归实现delete()
     * 1. ArrayList<Object> result 用来保存被删除节点的值
        2. 第二、第三个 if 对应没找到的情况，继续递归查找和删除，注意后续的 doDelete 返回值代表删剩
        下的，因此需要更新
        3. 最后一个 return 对应删除节点只有一个孩子的情况，返回那个不为空的孩子，待删节点自己因没
        有返回而被删除
        4. 第四个 if 对应删除节点有两个孩子的情况，此时需要找到后继节点，并在待删除节点的右子树中删
        掉后继节点，最后用后继节点替代掉待删除节点返回，别忘了改变后继节点的左右指针
     * public Object delete(int key) {
     * ArrayList<Object> result = new ArrayList<>();
     * root = doDelete(root, key, result);
     * return result.isEmpty() ? null : result.get(0);
     * }
     * public BSTNode doDelete(BSTNode node, int key, ArrayList<Object> result) {
     * if (node == null) {
     * return null;
     * }
     * if (key < node.key) {
     * node.left = doDelete(node.left, key, result);
     * return node;
     * }
     * if (node.key < key) {
     * node.right = doDelete(node.right, key, result);
     * return node;
     * }
     * result.add(node.value);
     * if (node.left != null && node.right != null) {
     * BSTNode s = node.right;
     * while (s.left != null) {
     * s = s.left;
     * }
     * s.right = doDelete(node.right, s.key, new ArrayList<>());
     * s.left = node.left;
     * return s;
     * }
     * return node.left != null ? node.left : node.right;
     * }
     */

    /**
     * 找出所有比key结点小的值
     * @param key 关键字
     * @return 更小值的集合
     */
    public List<E> less(T key) {
        ArrayList<E> result = new ArrayList<>();
        ArrayDeque<BSTNode<E, T>> stack = new ArrayDeque<>();
        BSTNode<E, T> current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.right;
            } else {
                BSTNode<E, T> pop = stack.pop();
                if (pop.key.compareTo(key) < 0) {
                    result.add(pop.value);
                }
                current = pop.left;
            }
        }
        return result;
    }

    /**
     * 找出所有比key结点大的值
     * @param key 关键字
     * @return 更大值的集合
     */
    public List<E> greater(T key) {
        ArrayList<E> result = new ArrayList<>();
        ArrayDeque<BSTNode<E, T>> stack = new ArrayDeque<>();
        BSTNode<E, T> current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.right;
            } else {
                BSTNode<E, T> pop = stack.pop();
                if (pop.key.compareTo(key) > 0) {
                    result.add(pop.value);
                } else {
                    break;
                }
                current = pop.left;
            }
        }
        return result;
    }

    /**
     * 找出所有比key1结点大的值并且比key2结点小的值
     * @param key1 关键字1
     * @param key2 关键字2
     * @return >=key1 && <=key2
     */
    public List<E> between(T key1, T key2) {
        ArrayList<E> result = new ArrayList<>();
        ArrayDeque<BSTNode<E, T>> stack = new ArrayDeque<>();
        BSTNode<E, T> current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.right;
            } else {
                BSTNode<E, T> pop = stack.pop();
                if (pop.key.compareTo(key2) <= 0 && pop.key.compareTo(key1) >= 0) {
                    result.add(pop.value);
                } else if (pop.key.compareTo(key2) > 0) {
                    break;
                }
                current = pop.left;
            }
        }
        return result;
    }

    public void preOrder(BSTNode<E, T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + "\t");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(BSTNode<E, T> root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + "\t");
        inOrder(root.right);
    }
    public void postOrder(BSTNode<E, T> root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + "\t");
    }

}
