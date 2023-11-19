package datastructure.tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author qzy
 * @time 2023/11/17 8:16 星期五
 * @title 哈夫曼树
 */
public class HuffmanTree {
    /**
     * 节点类
     */
    static class Node {
        Character ch;   // 字符
        int freq;   // 频次
        Node left;
        Node right;
        String code; // 编码

        public Node(Character ch) {
            this.ch = ch;
        }

        public Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public int getFreq() {
            return freq;
        }

        public boolean isLeaf() {
            return left == null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "ch=" + ch +
                    ", freq=" + freq +
                    ", left=" + left +
                    ", right=" + right +
                    ", code='" + code + '\'' +
                    '}';
        }
    }

    Node root;
    String str;
    HashMap<Character, Node> map;

    /**
     * 构造函数
     * @param str 输入的字符串
     */
    public HuffmanTree(String str) {
        this.str = str;
        map = new HashMap<>();

        /*
            1、统计频率
         */
        for (char c : str.toCharArray()) {
            // 如果字符c不在map中，则将c和一个新的Node(c)放入map
            // 否则获取c对应的Node，并将频次加一
            Node node = map.computeIfAbsent(c, Node::new);
            node.freq++;
        }

        /*
            2、构造树
         */
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getFreq));
        queue.addAll(map.values());
        while (queue.size() >= 2) {
            Node x = queue.poll();
            Node y = queue.poll();
            int freq = x.freq + y.freq;
            queue.offer(new Node(freq, x, y));
        }
        root = queue.poll();
        System.out.println(root);

        /*
            3、计算每个字符的编码
            4、字符串编码后占用的 bits
         */
        int sum = dfs(root, new StringBuilder());
        for (Node node : map.values()) {
            System.out.println(node + " " + node.code);
        }
        System.out.println("总共会占用 bits:" + sum);
    }

    /**
     * 深度优先搜索遍历哈夫曼树
     * @param node 当前节点
     * @param code 当前节点的编码
     * @return 返回字符串编码后占用的 bits
     */
    private int dfs(Node node, StringBuilder code) {
        int sum = 0;
        if (node.isLeaf()) {
            // 如果是叶子节点，设置编码并计算编码占用的总位数
            node.code = code.toString();
            sum = node.freq * code.length();
        } else {
            // 如果是内部节点，递归遍历左右子树，并累加编码占用的位数
            sum += dfs(node.left, code.append("0"));
            sum += dfs(node.right, code.append("1"));
        }
        if (!code.isEmpty()) {
            // 删除当前节点添加的编码位，以便回溯到上一层节点
            code.deleteCharAt(code.length() - 1);
        }
        return sum;
    }

    /**
     * 对输入的字符串进行编码
     * @param input 输入的字符串
     * @return 编码后的字符串
     */
    public String encode(String input) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : input.toCharArray()) {
            Node node = map.get(c);
            if (node != null) {
                encodedString.append(node.code);
            } else {
                // 处理无法编码的字符，例如抛出异常或者进行其他处理
                throw new RuntimeException("？¿?");
            }
        }
        return encodedString.toString();
    }

    /**
     * 对编码后的字符串进行解码
     * @param encodedStr 编码后的字符串
     * @return 解码后的字符串
     */
    public String decode(String encodedStr) {
        /*
            从根节点，寻找数字对应的字符
            数字是 0 向左走
            数字是 1 向右走
            如果没走到头，每走一步数字的索引 i++
            走到头就可以找到解码字符，再将 node 重置为根节点
        */
        int i = 0;
        Node node = root;
        char[] chars = encodedStr.toCharArray();
        StringBuilder decodingStr = new StringBuilder();
        while (i < chars.length) {
            if (!node.isLeaf()) { // 非叶子
                if(chars[i] == '0') { // 向左走
                    node = node.left;
                } else if(chars[i] == '1') { // 向右走
                    node = node.right;
                }
                i++;
            }
            if (node.isLeaf()) {    // 叶子
                decodingStr.append(node.ch);
                node = root;
            }
        }
        return decodingStr.toString();
    }
}
