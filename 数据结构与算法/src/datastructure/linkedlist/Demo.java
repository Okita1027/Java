package datastructure.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author qzy
 * @time 2023/9/13 9:05 星期三
 */
public class Demo {
    @Test
    void test01() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addHead(1);
        list.addHead(2);
        list.addHead(3);
        list.loop(System.out::print);
        System.out.println("\n============");
        list.addTrail(1);
        list.addTrail(2);
        list.addTrail(3);
        list.loop(System.out::print);
        System.out.println("\n============");
        list.add(3, 9);
        list.loop(System.out::print);
        System.out.println("\n============");
        int removed = list.remove(1);
        System.out.println(removed);
        list.loop(System.out::print);
        System.out.println("\n============");
        System.out.println(list.get(1));
        System.out.println("\n============");
        list.loopRecursion();
        System.out.println("\n============");
    }

}
