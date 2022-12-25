package pattern.actor.iterator;

import java.util.ArrayList;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 迭代器模式
 * @Date 2022/12/24 16:18 星期六
 */
public class Client {
    public static void main(String[] args) {
        Student student1 = new Student("qzy");
        Student student2 = new Student("zk");
        Student student3 = new Student("hlf");
        Student student4 = new Student("jh");

        StudentAggregateImpl studentAggregate = new StudentAggregateImpl();
        studentAggregate.addStudent(student1);
        studentAggregate.addStudent(student2);
        studentAggregate.addStudent(student3);
        studentAggregate.addStudent(student4);

        StudentIterator iterator = studentAggregate.getIterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }

    }
}
