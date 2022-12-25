package pattern.actor.iterator;

/**
 * @Author qzy
 * @ClassName StudentIterator
 * @Description 抽象迭代器（Iterator）角色：定义访问和遍历聚合元素的接口，通常包含 hasNext()、
 * next() 等方法。
 * @Date 2022/12/24 16:08 星期六
 */
public interface StudentIterator {

    boolean hasNext();

    Student next();
}
