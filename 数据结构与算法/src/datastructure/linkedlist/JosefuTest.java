package datastructure.linkedlist;

/**
 * @time 2022/6/3 10:36 星期五
 * 循环链表-约瑟夫问题
 */
public class JosefuTest {
    public static void main(String[] args) {
        Node<Integer> trailNode = new Node(1);
        Node<Integer> firstNode = trailNode;
        for (int i = 2; i <= 40 ; i++) {
            Node<Integer> newNode = new Node<>(i);
            trailNode.next = newNode;
            trailNode = newNode;
        }
        Node<Integer> lastNode = new Node<>(41);
        lastNode.next = firstNode;
        trailNode.next = lastNode;

        System.out.println("遍历原链表:");
        Node temp = firstNode.next;
        while (temp != firstNode) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println();

        System.out.println("约瑟夫问题：");
        int count = 0;
        Node<Integer> preNode = null;
        Node<Integer> nextNode = firstNode;
        while (nextNode.next != nextNode) {
            count++;
            if (count == 3) {
                System.out.print(nextNode.data + "\t");
                preNode.next = nextNode.next;
                nextNode = nextNode.next;
                count = 0;
            } else {
                preNode = nextNode;
                nextNode = nextNode.next;
            }
        }
        System.out.println(nextNode.data);
        System.out.println("最后输出的是16与31！");
    }
}
