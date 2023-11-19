package datastructure.tree;

import org.junit.jupiter.api.Test;

/**
 * @time 2022/6/9 20:59 星期四
 */
public class TreeDemo {
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

    @Test
    void BinaryTree0() {
        TreeNode0 root = new TreeNode0(1,
                new TreeNode0(2, new TreeNode0(4, null, null), new TreeNode0(7, null, null)),
                new TreeNode0(3, new TreeNode0(5, null, null), new TreeNode0(6, null, null)));
        BinaryTree0 tree = new BinaryTree0(root);
        tree.preOrderRecursion(root);
        System.out.println();
        tree.midOrderRecursion(root);
        System.out.println();
        tree.postOrderRecursion(root);

        System.out.println("\n=========================");

        tree.preOrderLoop(root);
        System.out.println();
        tree.midOrderLoop(root);
        System.out.println();
        tree.postOrderLoop(root);

        System.out.println("\n=========================");

        tree.commonOrderLoop(root);

        System.out.println("\n=========================");

        tree.layerTraversal();
    }

    @Test
    void BST() {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
        bst.put(2,2);
        bst.put(3,3);
        bst.put(4,4);
        bst.put(1,1);
        bst.put(0,0);
        bst.preOrder(bst.getRoot());
        System.out.println();
        bst.inOrder(bst.getRoot());
        System.out.println();
        bst.postOrder(bst.getRoot());

        System.out.println();
        bst.delete(2);
        bst.inOrder(bst.getRoot());
    }

    @Test
    void fun() {
        TreeNode0 root = new TreeNode0(8);
        root.left = new TreeNode0(5, new TreeNode0(1), new TreeNode0(7, new TreeNode0(6), null));
        root.right = new TreeNode0(10, null, new TreeNode0(12));
        BinaryTree0 tree = new BinaryTree0(root);
        tree.preOrderRecursion(root);
    }

    @Test
    void HuffmanTree() {
        HuffmanTree tree = new HuffmanTree("abcccccccc");
        System.out.println("tree = " + tree);
    }
}
