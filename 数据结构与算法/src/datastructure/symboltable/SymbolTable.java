package datastructure.symboltable;

/**
 * @time 2022/6/3 18:09 星期五
 * SymbolTable（符号表）->map
 */
public class SymbolTable<Key extends Comparable<Key>, Value> {
    public static void main(String[] args) {
        SymbolTable<Integer, Integer> map = new SymbolTable<>();
        map.put(1,1);
        map.put(3,3);
        map.put(4,3);
        map.put(2,2);
        map.put(1,21);
        map.remove(2);
        map.show();
        System.out.println("map.get(1) = " + map.get(1));
    }

    private int size;
    private Node<Key, Value> head;

    public SymbolTable() {
        this.size = 0;
        this.head = new Node(null, null, null);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(Key key, Value value) {
        Node<Key, Value> pre = head;
        Node<Key, Value> curr = head.next;
        while (curr != null && curr.key.compareTo(key) < 0) {
            pre = curr;
            curr = curr.next;
        }
        if (curr != null && curr.key.compareTo(key) == 0) {
            curr.value = value;
            return;
        }
        pre.next = new Node<>(key, value, curr);
        size++;
    }

    public void remove(Key key) {
        Node<Key, Value> pre = head;
        Node<Key, Value> temp = head.next;
        while (temp != null) {
            if (temp.key.equals(key)) {
                pre.next = temp.next;
                break;
            }
            pre = temp;
            temp = temp.next;
        }
    }

    public Value get(Key key) {
        Node<Key, Value> temp = head.next;
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public void show() {
        Node temp = head.next;
        while (temp != null) {
            System.out.print(temp.key + ":" + temp.value + "; ");
            temp = temp.next;
        }
    }
    static class Node<Key, Value>
    {
        public Key key;
        public Value value;
        public Node<Key, Value> next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

}
