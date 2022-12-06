package datastructure.tree;

import java.util.ArrayList;

/**
 * @time 2022/6/3 22:01 星期五
 * 二叉树
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {
    public static void main(String[] args) {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.put(5, 5);
        tree.put(2, 2);
        tree.put(1, 1);
        tree.put(3, 3);
        tree.put(0, 0);
        tree.put(4, 4);
        tree.put(6, 6);
        tree.put(8, 8);
        tree.put(7, 7);
        tree.put(9, 9);
        tree.put(10, 10);
//        System.out.println(tree.get(0));
//        System.out.println(tree.min().value);
//        System.out.println(tree.max().value);
//        System.out.println(tree.preErgodic());
//        System.out.println(tree.midErgodic());
//        System.out.println(tree.aftErgodic());
//        System.out.println(tree.size);
//        tree.remove(2);
//        tree.remove(1);
//        System.out.println(tree.size);
//        System.out.println("===============");
//        Queue<Integer> queue = new Queue<>(10);
//        queue.push(new NodeQueue<>(1, null));
//        queue.push(new NodeQueue<>(3, null));
//        queue.push(new NodeQueue<>(2, null));
//        queue.show();
//        System.out.println("\n===============");
//        System.out.println("queue.pop() = " + queue.pop());
//        queue.show();
//        System.out.println("\n=================");
        System.out.println(tree.maxDepth());
    }

    //根节点、元素个数
    private Node<Key, Value> root;
    private int size;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Node<Key, Value> put(Node<Key, Value> x, Key key, Value value) {
        //若该子树为空，则直接插入
        if (x == null) {
            size++;
            return new Node<>(key, value, null, null);
        }
        //比较传入的key与该子树的key
        //若等于则直接替换该值；若大于则继续查找右子树；若小于则继续查找左子树
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node<Key, Value> node, Key key) {
        //若没有该节点，则返回空
        if (node == null) {
            return null;
        }
        //比较传入的键与当前节点的键
        int cmp = key.compareTo(node.key);
        //如果小于则继续查找该节点的左子树
        //如果大于则继续查找该节点的右子树
        //如果等于则直接返回该节点的值
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public void remove(Key key) {
        remove(root, key);
    }

    public Node<Key, Value> remove(Node<Key, Value> node, Key key) {
        //若没有该节点，则返回false
        if (node == null) {
            return null;
        }
        //比较传入的键与当前节点的键
        int cmp = key.compareTo(node.key);
        //如果小于则继续查找该节点的左子树
        //如果大于则继续查找该节点的右子树
        //如果等于则直接删除该节点
        if (cmp < 0) {
            return remove(node.left, key);
        } else if (cmp > 0) {
            return remove(node.right, key);
        } else {
            //让元素个数-1
            size--;
            //若该节点左边没有节点了，就直接返回该节点的右节点
            //让该节点的父节点指向该节点的右节点
            if (node.left == null) {
                return node.right;
            //若该节点右边没有节点了，就直接返回该节点的左节点
            //让该节点的父节点指向该节点的左节点
            }else if (node.right == null) {
                return node.left;
            }
            //若该节点两边都有节点，就找出子树下的最小节点
            //即从该节点的右子树开始一直往左查找
            Node<Key, Value> minNode = node.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //删除右子树
            Node<Key, Value> removeNode = node.right;
            while (removeNode.left != null) {
                if (removeNode.left.left == null) {
                    if (removeNode.left.right != null) {
                        removeNode.left = removeNode.left.right;
                    } else {
                        removeNode.left = null;
                    }
                } else {
                    removeNode = removeNode.left;
                }
            }
            //让得到的最小节点的左子树指向被删除节点的父节点的左子树
            minNode.left = node.left;
            //让得到的最小节点的右子树指向被删除节点的父节点的右子树
            minNode.right = node.right;
            if (node == root) {
                root = minNode;
            } else {
                node = minNode;
            }
        }
        return node;
    }

    public Node<Key, Value> min() {
        Node<Key, Value> temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public Node<Key, Value> max() {
        Node<Key, Value> temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    //前序遍历:根、左、右
    public ArrayList<Key> preErgodic() {
        ArrayList<Key> keys = new ArrayList<>();
        preErgodic(root, keys);
        return keys;
    }

    private void preErgodic(Node<Key, Value> x, ArrayList<Key> keys) {
        if (x == null) {
            return;
        }
        keys.add(x.key);
        if (x.left != null) {
            preErgodic(x.left, keys);
        }
        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }

    //中序遍历:左、根、右
    public ArrayList<Key> midErgodic() {
        ArrayList<Key> keys = new ArrayList<>();
        midErgodic(root, keys);
        return keys;
    }
    private void midErgodic(Node<Key, Value> x, ArrayList<Key> keys) {
        if (x == null) {
            return;
        }
        if (x.left != null) {
            midErgodic(x.left, keys);
        }
        keys.add(x.key);
        if (x.right != null) {
            midErgodic(x.right, keys);
        }
    }

    //后序遍历:左、右、根
    public ArrayList<Key> aftErgodic() {
        ArrayList<Key> keys = new ArrayList<>();
        aftErgodic(root, keys);
        return keys;
    }

    private void aftErgodic(Node<Key, Value> x, ArrayList<Key> keys) {
        if (x == null) {
            return;
        }
        if (x.left != null) {
            aftErgodic(x.left, keys);
        }
        if (x.right != null) {
            aftErgodic(x.right, keys);
        }
        keys.add(x.key);
    }

    //层次遍历
    //此处需要创建一个专用于存放Node的队列（Queue）
//    public Queue<Key>layerErgodic() {
//        Queue<Key> keys = new Queue<>(size);
//        Queue<Node<Key, Value>> nodes = new Queue<>(10);
//        nodes.push(root);
//        while (nodes.isEmpty()) {
//            Node<Key, Value> pop = nodes.pop();
//            keys.push((NodeQueue<Key>) pop.key);
//            if (pop.left != null) {
//                nodes.push(pop.left);
//            }
//            if (pop.right != null) {
//                nodes.push(pop.right);
//            }
//        }
//        return keys;
//    }

    //计算树的最大深度
    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node<Key, Value> root) {
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight,rightHeight) + 1;
    }

}

class Node<Key extends Comparable<Key>, Value> {
    public Key key;
    public Value value;
    public Node<Key, Value> left;
    public Node<Key, Value> right;

    public Node(Key key, Value value, Node<Key, Value> left, Node<Key, Value> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

}

class Queue<T>
{
    private int count;
    private final int maxSize;
    private NodeQueue<T> front;
    private NodeQueue<T> rear;

    public Queue(int maxSize) {
        count = 0;
        this.maxSize = maxSize;
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == maxSize;
    }

    public int getCount() {
        return count;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void push(NodeQueue<T> node) {
        if (isFull()) {
            return;
        }
        if (isEmpty()) {
            front = node;
            rear = node;
        } else {
            front.next = node;
            front = node;
        }
        count++;
    }

    public T pop() {
        NodeQueue<T> temp = rear;
        rear = rear.next;
        return temp.data;
    }

    public void show() {
        NodeQueue<T> temp = rear;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }
}

class NodeQueue<T> {
    T data;
    NodeQueue<T> next;

    public NodeQueue(T data, NodeQueue<T> next) {
        this.data = data;
        this.next = next;
    }
}