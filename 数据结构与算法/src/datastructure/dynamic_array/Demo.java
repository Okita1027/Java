package datastructure.dynamic_array;

import org.junit.jupiter.api.Test;

/**
 * @author qzy
 * @time 2023/9/12 10:49 星期二
 */
public class Demo {

    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.addLast(1);
        array.addLast(3);
        array.addLast(2);
        array.foreach((element) -> System.out.print(element));
        System.out.print("==========");

        array.add(2,5);
        array.foreach(System.out::print);

        System.out.println("==========");
        array.addLast(0);
        for (Integer integer : array) {
            System.out.print(integer);
        }

        System.out.println("==========");
        array.addLast(8);
        array.intStream().forEach(System.out::print);

        System.out.println("==========");
        int removed = array.remove(1);

        System.out.println("removed = " + removed);
        System.out.println("==========");

        System.out.println("==========");
        System.out.println("==========");

    }

}
