package pattern.actor.iterator;

import java.util.List;

/**
 * @Author qzy
 * @ClassName StudentIteratorImpl
 * @Description 具体迭代器（ConcreteIterator）角色：实现抽象迭代器接口中所定义的方法，完成对聚合对
 * 象的遍历，记录遍历的当前位置。
 * @Date 2022/12/24 16:09 星期六
 */
public class StudentIteratorImpl implements StudentIterator{

    private List<Student> studentList;
    private int position;

    public StudentIteratorImpl(List<Student> studentList) {
        this.studentList = studentList;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < studentList.size();
    }

    @Override
    public Student next() {
        return studentList.get(position++);
    }
}
