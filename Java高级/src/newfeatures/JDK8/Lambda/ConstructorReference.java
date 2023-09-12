package newfeatures.JDK8.Lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @time 2022/5/8 17:38 星期日
 * 一：构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 *      抽象方法的返回值类型即为构造器所属的类
 * 二：数组引用
 *      把数组看做是一个特殊的类,则写法与构造器引用一致。
 */
public class ConstructorReference {
    //构造器引用
    //Supplier中的T get()
    @Test
    public void test1() {
        Supplier<Worker> supplier1 = () -> new Worker("黄凌烽");
        System.out.println(supplier1.get());
        System.out.println("===============");
        Supplier<Worker> supplier2 = Worker::new;
        System.out.println(supplier2.get());
    }

    @Test
    public void test2() {
        Function<String, Worker> fun1 = name -> new Worker(name);
        System.out.println(fun1.apply("秦智耘"));
        System.out.println("===============");
        Function<String, Worker> fun2 = Worker::new;
        System.out.println(fun2.apply("叶晨康"));
    }

    @Test
    public void test3() {
        BiFunction<String, Integer, Worker> fun1 = (name, age) -> new Worker(name, age);
        System.out.println(fun1.apply("秦智耘", 19));
        System.out.println("===============");
        BiFunction<String, Integer, Worker> fun2 = Worker::new;
        System.out.println(fun2.apply("赵科", 19));
    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4() {
        Function<Integer, String[]> fun1 = length -> new String[length];
        String[] strings = fun1.apply(5);
        System.out.println("strings = " + Arrays.toString(strings));
        Function<Integer, Integer[]> fun2 = Integer[]::new;
        Integer[] integers = fun2.apply(3);
        System.out.println("integers = " + Arrays.toString(integers));
    }

}
