package newfeatures.JDK8.Lambda;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @time 2022/5/8 14:48 星期日
 * 函数式接口，即只能有一个抽象方法
 * Java内置四大核心函数式接口：
 * Consumer<T>消费型接口：void accept(T t)
 * Supplier<T>供给型接口：T get()
 * Function<T,R>函数型接口：对类型为T的对象应用操作：R apply(T t)
 * Predicate<T>断定型接口：确定类型为T的对象是否满足某约束：boolean test(T t)
 */
public class Lambda02 {
    @Test
    public void test1() {
        happyTime("雪碧", new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("喝" + s);
            }
        });

        String water = "可乐";
        happyTime(water, s -> System.out.println("喝" + s));
    }

    private void happyTime(String drink, Consumer<String> consumer) {
        consumer.accept(drink);
    }

    @Test
    public void test2() {
        double salary = 1000;
        System.out.println(sendSalary(() -> salary));
    }

    private double sendSalary(Supplier<Double> supplier) {
        return supplier.get();
    }

    @Test
    public void test3() {
        Function<Integer, String> function = new Function<>() {
            @Override
            public String apply(Integer integer) {
                return integer.toString() + "toString()";
            }
        };
        String apply = function.apply(100);
        System.out.println("apply = " + apply);
    }

    @Test
    public void test4() {
        Predicate<Integer> predicate = new Predicate<>(){
            @Override
            public boolean test(Integer i) {
                return i == 1;
            }
        };
        boolean test = predicate.test(1);
        System.out.println("test = " + test);
    }

}
