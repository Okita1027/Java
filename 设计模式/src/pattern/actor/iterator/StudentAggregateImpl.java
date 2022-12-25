package pattern.actor.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qzy
 * @ClassName StudentAggregateImpl
 * @Description 具体聚合（ConcreteAggregate）角色：实现抽象聚合类，返回一个具体迭代器的实例。
 * @Date 2022/12/24 16:14 星期六
 */
public class StudentAggregateImpl implements StudentAggregate{
    private List<Student> studentList;

    public StudentAggregateImpl() {
        studentList = new ArrayList<>();
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    @Override
    public StudentIterator getIterator() {
        return new StudentIteratorImpl(studentList);
    }
}
