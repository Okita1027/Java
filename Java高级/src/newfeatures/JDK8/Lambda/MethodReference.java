package newfeatures.JDK8.Lambda;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @time 2022/5/8 15:58 星期日
 * Lambda表达式进阶->方法引用
 * 1.使用情境:当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用!
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以方法引用也是函数式接口的实例。
 * 3．使用格式:类(或对象)::方法名4．具体分为如下的三种情况:
 * ①对象::非静态方法    ②类::静态方法     ③类::非静态方法
 * 5．方法引用使用的要求:要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的
 * 形参列表和返回值类型相同!(针对于情况①和情况②)
 */
public class MethodReference {
    @Test
    public void test1() {
        //情况1：对象 :: 实例方法
        //Consumer中的void accept(T t)
        //PrintStream中的void println(T t)
        Consumer<String> consumer1 = str -> System.out.println(str);
        consumer1.accept("100块钞票");
        System.out.println("=============");
        PrintStream out = System.out;
        Consumer<String> consumer2 = out::println;
    }

    @Test
    public void test2() {
        Worker tom = new Worker("Tom");
        Supplier<String> supplier = () -> tom.getName();
        String s = supplier.get();
        System.out.println("s = " + s);
        System.out.println("============");
        supplier = tom::getName;
        s = supplier.get();
        System.out.println("s = " + s);
    }

    @Test
    public void test3() {
        //情况二:类::静态方法
        //comparator中的int compare(T t1,T t2)
        //integer中的int compare(T t1,T t2)
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(12, 21));
        System.out.println("===============");
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(34, 43));
    }

    @Test
    public void test4() {
        //Function 中的 R apply(T t)
        //Math中的Long round(Double d)
        Function<Double, Long> function1 = new Function<>() {
            @Override
            public Long apply(Double num) {
                return Math.round(num);
            }
        };
        Long apply = function1.apply(12.34);
        System.out.println("apply = " + apply);

        System.out.println("===============");
        Function<Double, Long> function2 = num -> Math.round(num);
        System.out.println("===============");
        Function<Double, Long> function3 = Math::round;
    }

    @Test
    public void test5() {
        //情况三:类::实例方法（当compare的t1参数用于调用compareTo方法时，
        // t1参数等同于没写在compareTo方法中)
        //Comparator中的int compare(T t1,T t2)
        //String中的int t1.compareTo(t2)
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("A", "Z"));
        System.out.println("===============");
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("Z", "A"));
    }

    //BiPredicate中的booLean test(T t1,T t2);
    //String中的boolean t1.equals(t2)
    @Test
    public void test6() {
        BiPredicate<String, String> pre1 = (str1, str2) -> str1.equals(str2);
        System.out.println(pre1.test("qwe", "ewq"));
        System.out.println("===============");
        BiPredicate<String, String> pre2 = String::equals;
        System.out.println(pre2.test("asd", "dsa"));
    }

//    Function中的R apply(T t)
//    Worker中的int getAge()
    @Test
    public void test7() {
        Worker jack = new Worker("Jack");
        Function<Worker, String> function1 = worker -> worker.getName();
        System.out.println(function1.apply(jack));
        System.out.println("===============");
        Function<Worker, String> function2 = Worker::getName;
        System.out.println(function2.apply(jack));
    }
}
