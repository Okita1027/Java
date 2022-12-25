package pattern.actor.iterator;

/**
 * @Author qzy
 * @ClassName StudentAggregate
 * @Description 抽象聚合（Aggregate）角色：定义存储、添加、删除聚合元素以及创建迭代器对象的接口。
 * @Date 2022/12/24 16:12 星期六
 */
public interface StudentAggregate {

    void addStudent(Student student);

    void removeStudent(Student student);

    StudentIterator getIterator();

}
