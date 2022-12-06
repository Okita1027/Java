package newfeatures.JDK8.Lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @time 2022/5/7 22:19 星期六
 * Lambda表达式的使用
 * 1.举例:(o1,o2) -> Integer.compare(o1,o2);
 * 2.格式:
 *      ->:Lambda操作符或箭头操作符
 *      ->左边: Lambda形参列表(其实就是接口中的抽象方法的形参列表)
 *      ->右边: Lambda体(其实就是重写的抽象方法的方法体)
 * 3.Lambda表达式的使用:(分为6种情况)
 *  总结：
 *      ->左边：Lambda形参列表的参数类型可以省略;如果Lambda形参列表只有一个参数，其一对()也可以省略
 *      ->右边：Lambda体应该使用一对{}包裹;如果Lambda体只有一条执行语句（可能是return语句),省略这一对{}和return
 *
 * 4.Lambda表达式的本质: 作为函数式接口的实例，即接口只能有一个抽象方法
 */

public class Lambda01 {
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是传统方法！");
            }
        };
        r1.run();
        System.out.println("========================");
        //语法格式1：无参，无返回值
        Runnable r2 = () -> {
            System.out.println("语法格式1：无参，无返回值！");
        };
        r2.run();
    }

    @Test
    public void test2() {
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("这是老方法！");
        System.out.println("========================");
        //语法格式2：lambda需要一个参数，但没有返回值
        Consumer<String> con2 = (String s) -> {
            System.out.println(s);
        };
        con2.accept("语法格式2：lambda需要一个参数，但没有返回值");
    }

    @Test
    public void test3() {
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("老方法！");
        //语法格式3：数据类型可以省略，因为可由编译器推断得出，称为 ”类型推断“
        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("语法格式3：数据类型可以省略，因为可由编译器推断得出，称为 ”类型推断“！");

        //另外一个类型推断实例：
        ArrayList<String> list = new ArrayList<>();
//        int[] arr1 = new int[] {1, 2, 3};
        int[] arr2 = {1, 2, 3};//赋值就是给的int，所以也不可能是实例化别的类型的数组
    }

    @Test
    public void test4() {
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("老方法！");
        System.out.println("========================");
        //语法格式4：Lambda只需要一个参数时，参数的小括号可以省略
        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("语法格式4：Lambda只需要一个参数时，参数的小括号可以省略！");
    }

    @Test
    public void test5() {
        //语法格式5：Lambda需要两个或以上参数，多条执行语句，并且可以有返回值
        Comparator<Integer> com1 = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 21));
        System.out.println("========================");
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(34, 43));
    }

    @Test
    public void test6() {
        //
        Comparator<Integer> com1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(34, 43));
        System.out.println("========================");
        //语法格式6：当Lambda体只有一条语句时，可以省略return和大括号
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);

        Consumer<String> con = s -> System.out.println(s);
    }
}
