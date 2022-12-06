package datastructure.linkedlist;

/**
 * @time 2022/5/28 14:57 星期六
 * 带有头节点的单链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList<String> stringSingleLinkedList = new SingleLinkedList<>();
        stringSingleLinkedList.add(new Node<>("1"));
        stringSingleLinkedList.add(new Node<>("3"));
        stringSingleLinkedList.add(new Node<>("5"));
        stringSingleLinkedList.showList();
        System.out.println("===========================");
        stringSingleLinkedList.addByIndex(2, new Node<>("999"));
        stringSingleLinkedList.showList();
        System.out.println("===========================");
        stringSingleLinkedList.addByIndex(1, new Node<>("666"));
        stringSingleLinkedList.showList();
        System.out.println("===========================");
        stringSingleLinkedList.addByIndex(6, new Node<>("888"));
        stringSingleLinkedList.showList();
        System.out.println("===========================");
        stringSingleLinkedList.remove(5);
        stringSingleLinkedList.showList();
        System.out.println("===========================");
        stringSingleLinkedList.update(3, "333");
        stringSingleLinkedList.showList();
        System.out.println("===========================");
        stringSingleLinkedList.reverse();
        stringSingleLinkedList.showList();
        System.out.println("===========================");
        System.out.println("该链表中间值为： " + stringSingleLinkedList.getMid());
        System.out.println("===========================");
        stringSingleLinkedList.getHead().next.next.next = stringSingleLinkedList.getHead().next;
        System.out.println("该链表是否有环：" + (stringSingleLinkedList.isCircle()?"有":"没有"));
        System.out.println("===========================");
        System.out.println("该链表的环的入口为：" + stringSingleLinkedList.getEntrance());
    }
}

class SingleLinkedList<T> {
    Node<Integer> head = new Node<>(0);

    public Node<Integer> getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public void add(Node<T> node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        //头结点存放元素个数
        head.data++;
    }

    //在指定位置插入新节点
    public void addByIndex(int index, Node<T> node) {
        Node temp = head;
        int count = 0;
        if (index < 1 || index > head.data + 1) {
            System.out.println("非法的index数据！");
            throw new RuntimeException("index can't < 0 or > maxSize");
        }
        //插入到末尾
        if (index == head.data + 1) {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            node.next = null;
            temp.next = node;
            head.data++;
            return;
        }
        //插入到中间位置
        while (temp.next != null) {
            count++;
            if (count == index) {
                node.next = temp.next;
                temp.next = node;
                head.data++;
                return;
            }
            temp = temp.next;
        }
    }

    //删除指定位置的节点
    public void remove(int index) {
        if (index < 1 || index > head.data) {
            return;
        }
        Node temp = head;
        //删除的是正好第一个非头结点的节点
        if (index == 1) {
            head.next = temp.next;
            temp = null;
            return;
        }
        //删除的正好是最后一个节点
        if (index == head.data) {
            for (int i = 0; i < head.data - 1; i++) {
                temp = temp.next;
            }
            temp.next = null;
        }
        int count = 0;
        Node priorTemp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
            if (count == index) {
                for (int i = 0; i < count - 1; i++) {
                    priorTemp = priorTemp.next;
                }
                priorTemp.next = temp.next;
                temp = null;
                return;
            }
        }
    }

    //更新指定位置节点的值
    public void update(int index, T value) {
        if (index < 1 || index > head.data) {
            return;
        }
        if (index == 1) {
            head.next.data = value;
        }
        Node temp = head;
        if (index == head.data) {
            for (int i = 0; i < head.data; i++) {
                temp = temp.next;
            }
            temp.data = value;
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = value;
    }

    public void showList() {
        if (head.next == null) {
            return;
        }
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }
        reverse(head.next);
    }

    private Node reverse(Node cur) {
        if (cur.next == null) {
            head.next = cur;
            return cur;
        }
        Node pre = reverse(cur.next);
        pre.next = cur;
        cur.next = null;
        return cur;
//        while (cur.next != null) {
//            Node pre = reverse(cur.next);
//            pre.next = cur;
//            cur.next = null;
//            return cur;
//        }
//        head.next = cur;
//        return cur;
    }

    //快慢指针：取中间值
    public Object getMid() {
        if (isEmpty()) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    //快慢指针：判断是否有环
    public boolean isCircle() {
        Node slow = head.next;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //快慢指针：找到环的入口
    public Node getEntrance() {
        Node slow = head.next;
        Node fast = head.next;
        Node temp = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                temp = head.next;
                continue;
            }
            if (temp != null) {
                temp = temp.next;
                if (temp == slow) {
                    break;
                }
            }
        }
        return temp;
    }
}

class Node<T> {
    public T data;
    public Node next;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}