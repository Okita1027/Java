package newfeatures.StreamAPI;

import newfeatures.Lambda.Worker;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @time 2022/5/9 21:42 星期一
 * Stream的终止操作
 * 匹配与查找、归约
 */
public class StreamAPITest02 {
    //匹配与查找
    @Test
    public void test1() {
        Worker worker1 = new Worker(18);
        Worker worker2 = new Worker(19);
        Worker worker3 = new Worker(20);
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        // allMatch(Predicate p)检查是否匹配所有元素。练习:是否所有的员工的年龄都大于18
        System.out.println(workers.stream().allMatch(worker -> worker.getAge() > 18));
        // anyMatch(Predicate p)一检查是否至少匹配一个元素。练习:是否存在员工的工资大于10000
        System.out.println(workers.stream().anyMatch(worker -> worker.getSalary() > 5000));
        // noneMatch(Predicate p)检查是否没有匹配的元素。练习:是否存在员工姓秦，有返回false，否则true
        System.out.println(workers.stream().noneMatch(worker -> worker.getName().startsWith("秦")));
        // findFirst返回第一个元素
        Optional<Worker> optional = workers.stream().findFirst();
        System.out.println("optional = " + optional);
        // findAny返回当前流中的任意元素
        Optional<Worker> any = workers.stream().findAny();
        System.out.println("any = " + any);
        // count返回流中元素的总个数
        long count = workers.stream().filter(worker -> worker.getSalary() > 3000).count();
        System.out.println("count = " + count);
        // max(Comparator.c)一返回流中最大值练习:返回最高的工资
        Stream<Double> doubleStream = workers.stream().map(Worker::getSalary);
        Optional<Double> max = doubleStream.max(Double::compareTo);
        System.out.println("max = " + max);
        // min(Comparator c)返回流中最小值练习:返回最低工资的员工
        Optional<Worker> min = workers.stream().min(Comparator.comparingDouble(Worker::getSalary));
        System.out.println("min = " + min);
        // forEach(Consumer c)一内部迭代
        workers.stream().forEach(System.out::println);
        //使用集合的方法
        System.out.println();
        workers.forEach(System.out::println);
        System.out.println();
        //iterator--外部迭代
        Iterator<Worker> iterator = workers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //归约
    @Test
    public void test2() {
        //reduce(T identity， BinaryOperator)—可以将流中元素反复结合起来，得到一个值。返回T
        //练习1:计算1-10的自然数的和
        List<Integer> lists = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = lists.stream().reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
        //reduce(BinaryOperator)一可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        //练2:计算公司所有员工工资的总和
        Worker worker1 = new Worker(18);
        Worker worker2 = new Worker(19);
        Worker worker3 = new Worker(20);
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        Stream<Double> salaryStream = workers.stream().map(Worker::getSalary);
        Optional<Double> sumSalary = salaryStream.reduce(Double::sum);
        System.out.println("sumSalary = " + sumSalary);
    }

    //收集
    @Test
    public void test3() {
        //collect(collector c)--将流转换为其他形式。接收一个collector接口的实现，用于给stream
        // 练习1:查找工资大于6ee0的员工，结果返回为一个List或Set
        Worker worker1 = new Worker(18);
        Worker worker2 = new Worker(19);
        Worker worker3 = new Worker(20);
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        List<Worker> workerList = workers.stream().filter(worker -> worker.getSalary() > 1000).collect(Collectors.toList());
        workerList.forEach(System.out::println);
        Set<Worker> workerSet = workers.stream().filter(worker -> worker.getSalary() > 1000).collect(Collectors.toSet());
        workerSet.forEach(System.out::println);
    }
}
