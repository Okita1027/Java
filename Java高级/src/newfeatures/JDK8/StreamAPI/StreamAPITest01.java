package newfeatures.JDK8.StreamAPI;

import newfeatures.JDK8.Lambda.Worker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @time 2022/5/9 18:29 星期一
 * Stream的过程操作
 * StreamAPI：筛选、切片、映射、排序
 */
public class StreamAPITest01 {
    //筛选与切片
    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        for (int num : nums) {
            list.add(num);
        }
        //filter(Predicate p)—-接收Lambda ,从流中排除某些元素。
        //方法1：传统
        Stream<Integer> stream = list.stream();
        stream.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 5;
            }
        }).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer);
            }
        });
        System.out.println();
        //方法2：Lambda + 方法引用
        stream = list.stream();
        stream.filter(integer -> integer > 5).forEach(System.out::print);
        System.out.println();
        //Limit(n)——截断流,使其元素个数不超过给定数量。
        stream = list.stream();
        stream.limit(3).forEach(System.out::print);
        System.out.println();
        //skip(n)一跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。
        stream = list.stream();
        stream.skip(5).forEach(System.out::print);
        System.out.println();
        //distinct()—筛选，通过流所生成元素的hashcode()和equals()去除重复元素。
        list.add(1);
        list.add(1);
        stream = list.stream();
        stream.distinct().forEach(System.out::print);
    }

    //映射
    @Test
    public void test2() {
        //map(Function f)接收一个函数作为参数，将元素转换成其他形式或提取信息，
        // 该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::print);
        System.out.println();
        //获取工人年龄大于18的年龄
        Worker worker1 = new Worker(18);
        Worker worker2 = new Worker(19);
        Worker worker3 = new Worker(20);
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        Stream<Integer> ageStream = workers.stream().map(Worker::getAge);
        ageStream.filter(age -> age > 18).forEach(System.out::print);
        System.out.println();
        //flatMap(Function f)—接收一个函数作为参数，将流中的每个值都换成另一个流，
        //然后把所有流连接成一个流。
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest01::fromStringToStream);
        streamStream.forEach(characterStream -> characterStream.forEach(System.out::print));
        System.out.println();
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest01::fromStringToStream);
        characterStream.forEach(System.out::print);
        System.out.println();
    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }

    @Test
    public void test3() {
        //sorted()一自然排序
        List<Integer> list = Arrays.asList(12, 43, 33, 55, 7);
        list.stream().sorted().forEach(System.out::println);
        //sorted(Comparator com)—定制排序
        Worker worker1 = new Worker(18);
        Worker worker2 = new Worker(19);
        Worker worker3 = new Worker(17);
        Worker worker4 = new Worker(17);
        Worker worker5 = new Worker(17);
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        workers.add(worker4);
        workers.add(worker5);
        workers.stream().sorted((w1, w2) -> {
            int compare = Integer.compare(w1.getAge(), w2.getAge());
            if (compare != 0) {
                return compare;
            } else {
                return -Double.compare(w1.getSalary(), w2.getSalary());
            }
        }).forEach(System.out::print);
        System.out.println();
        workers.stream().sorted(Comparator.comparingInt(Worker::getAge)).forEach(System.out::print);
    }
}
