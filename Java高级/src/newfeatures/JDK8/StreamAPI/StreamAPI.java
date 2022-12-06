package newfeatures.JDK8.StreamAPI;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @time 2022/5/8 20:58 星期日
 * 1：
 * stream关注的是对数据的运算，与CPU打交道
 * 集合关注的是数据的存储，与内存打交道
 * 2：
 * ①Stream自己不会存储元素。
 * ②Stream不会改变源对象。相反，他们会返回一个持有结果的新Stream
 * ③Stream操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 * 3：Stream执行流程
 * ①Stream的实例化
 * ②—系列的中间操作（过滤、映射、...)
 * ③终止操作
 * 4:说明
 * ① 一个中间操作链，对数据源的数据进行处理
 * ② 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 */
public class StreamAPI {
    //创建Stream方式一：通过集合
    @Test
    public void t1() {
        ArrayList<Object> arrayList = new ArrayList<>();
        //default Stream<E> stream() 返回一个顺序流
        Stream<Object> stream = arrayList.stream();
        //default Stream<E> parallelStream() 返回一个并行流
        Stream<Object> parallelStream = arrayList.parallelStream();
    }

    //创建Stream方式二：通过数组
    @Test
    public void t2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        //调用Arrays类的static <T> Stream<T> stream(T[ ] array):返回一个流
        IntStream stream = Arrays.stream(arr);
    }

    //创建Stream方式三：通过Stream.of()
    @Test
    public void t3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    //创建Stream方式四：创建无限流
    @Test
    public void t4() {
        //迭代
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
